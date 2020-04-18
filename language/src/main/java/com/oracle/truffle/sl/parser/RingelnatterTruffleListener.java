package com.oracle.truffle.sl.parser;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.sl.FunctionBodyNode;
import com.oracle.truffle.sl.RingelnatterLanguage;
import com.oracle.truffle.sl.RingelnatterRootNode;
import com.oracle.truffle.sl.nodes.*;
import com.oracle.truffle.sl.nodes.expression.*;
import com.oracle.truffle.sl.runtime.ListTruffleObject;
import com.oracle.truffle.sl.runtime.RingelnatterFunctionRegistry;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class RingelnatterTruffleListener extends RingelnatterBaseListener {
    static class LexicalScope {
        protected final LexicalScope outer;
        protected final Map<String, FrameSlot> locals;

        LexicalScope(LexicalScope outer) {
            this.outer = outer;
            this.locals = new HashMap<>();
            if (outer != null) {
                locals.putAll(outer.locals);
            }
        }
    }

    private Source source;
    private final RingelnatterLanguage language;
    private final RingelnatterFunctionRegistry functionRegistry;

    // state for function
    private LexicalScope lexicalScope;
    private FrameDescriptor frameDescriptor;
    private List<StatementNode> statementNodes;

    // state for suites
    private boolean autoAddSuite = true;
    private Stack<List<StatementNode>> suites;
    private SuiteNode lastExitedSuite;

    public RingelnatterTruffleListener(RingelnatterLanguage language, Source source, RingelnatterFunctionRegistry functionRegistry) {
        this.source = source;
        this.language = language;
        this.functionRegistry = functionRegistry;
    }

    @Override
    public void enterFunction(RingelnatterParser.FunctionContext ctx) {
        List<TerminalNode> identifiers = ctx.IDENTIFIER();
        lexicalScope = new LexicalScope(null);
        frameDescriptor = new FrameDescriptor();
        statementNodes = new LinkedList<>();
        suites = new Stack<>();

        for (int i = 1; i < identifiers.size(); i++) {
            String parameterName = identifiers.get(i).getText();
            ReadArgumentNode readArgumentNode = new ReadArgumentNode(i - 1);
            WriteLocalVariableNode writeLocalVariableNode = createLocalVariable(parameterName, readArgumentNode);
            statementNodes.add(writeLocalVariableNode);
        }
    }

    @Override
    public void exitFunction(RingelnatterParser.FunctionContext ctx) {
        statementNodes.add(lastExitedSuite);

        String functionName = ctx.IDENTIFIER(0).getText();
        FunctionBodyNode body = new FunctionBodyNode(new SuiteNode(statementNodes.toArray(new StatementNode[0])));
        RingelnatterRootNode rootNode = new RingelnatterRootNode(language, frameDescriptor, functionName, body);
        functionRegistry.register(functionName, ctx.IDENTIFIER().size() - 1, Truffle.getRuntime().createCallTarget(rootNode));

        lexicalScope = null;
        frameDescriptor = null;
        statementNodes = null;
        lastExitedSuite = null;
    }

    @Override
    public void enterSuite(RingelnatterParser.SuiteContext ctx) {
        lexicalScope = new LexicalScope(lexicalScope);
        suites.push(new LinkedList<>());
    }

    @Override
    public void exitSuite(RingelnatterParser.SuiteContext ctx) {
        lexicalScope = lexicalScope.outer;

        List<StatementNode> nodes = suites.pop();
        SuiteNode suite = new SuiteNode(nodes.toArray(new StatementNode[0]));
        if(suites.size() > 0) {
            suites.peek().add(suite);
        }
        lastExitedSuite = suite;
    }

    @Override
    public void exitStmnt(RingelnatterParser.StmntContext ctx) {
        List<StatementNode> currentSuite = suites.peek();
        if(ctx.start.getText().equals("ret")) {
            currentSuite.add(new ReturnNode(parseExpression(ctx.expression())));
        } else if(ctx.start.getText().equals("let")) {
            verifyNonExistenceOfLocal(lexicalScope, ctx.var);
            currentSuite.add(createLocalVariable(ctx.IDENTIFIER().getText(), parseExpression(ctx.expression())));
        } else if(ctx.start.getText().equals("if")){
            ExpressionNode conditionalExpression = parseExpression(ctx.expression());
            currentSuite.remove(lastExitedSuite);
            currentSuite.add(new IfNode(ConditionalNodeGen.create(conditionalExpression), lastExitedSuite));
        } else if(ctx.start.getText().equals("while")){
            ExpressionNode conditionalExpression = parseExpression(ctx.expression());
            currentSuite.remove(lastExitedSuite);
            currentSuite.add(new WhileNode(ConditionalNodeGen.create(conditionalExpression), lastExitedSuite));
        } else if(ctx.var != null){
            ExpressionNode expression = parseExpression(ctx.expression());
            FrameSlot frameSlot = getLocalVariable(ctx.var);
            currentSuite.add(WriteLocalVariableNodeGen.create(expression, frameSlot));
        } else {
            throw new UnsupportedOperationException("Statement unknown");
        }
    }

    private ExpressionNode parseExpression(RingelnatterParser.ExpressionContext context) {
        if(context.logical_term() != null) {
            return parseLogicalTerm(context.logical_term());
        } else if (context.factor().size() > 0) {
            return parseConcatenation(context.factor());
        }
        return parseExpressionList(context.expression());
    }

    private ExpressionNode parseConcatenation(List<RingelnatterParser.FactorContext> factors) {
        LinkedList<ExpressionNode> list = new LinkedList<>();
        for (RingelnatterParser.FactorContext factor : factors)
            list.add(parseFactor(factor));
        return new ConcatNode(list.toArray(new ExpressionNode[0]));
    }

    private ExpressionNode parseExpressionList(List<RingelnatterParser.ExpressionContext> elements) {
        LinkedList<ExpressionNode> list = new LinkedList<>();
        for (RingelnatterParser.ExpressionContext element : elements)
            list.add(parseExpression(element));
        return new ListValueNode(list);
    }

    private ExpressionNode parseLogicalTerm(RingelnatterParser.Logical_termContext context){
        ExpressionNode leftOp = parseLogicalFactor(context.logical_factor(0));

        if(context.logical_factor().size() == 1)
            return leftOp;

        for (int i = 1; i < context.logical_factor().size(); i++) {
            ExpressionNode rightOp = parseLogicalFactor(context.logical_factor(i));
            leftOp = createBinary(context.op.getText(), leftOp, rightOp);
        }
        return leftOp;
    }

    private ExpressionNode parseLogicalFactor(RingelnatterParser.Logical_factorContext context){
        ExpressionNode leftOp = parseArithmetic(context.arithmetic(0));

        if(context.arithmetic().size() == 1)
            return leftOp;

        for (int i = 1; i < context.arithmetic().size(); i++) {
            ExpressionNode rightOp = parseArithmetic(context.arithmetic(i));
            leftOp = createBinary(context.op.getText(), leftOp, rightOp);
        }
        return leftOp;
    }

    private ExpressionNode parseArithmetic(RingelnatterParser.ArithmeticContext context){
        ExpressionNode leftOp = parseTerm(context.term(0));

        if(context.term().size() == 1)
            return leftOp;

        for (int i = 1; i < context.term().size(); i++) {
            ExpressionNode rightOp = parseTerm(context.term(i));
            leftOp = createBinary(context.op.getText(), leftOp, rightOp);
        }
        return leftOp;
    }

    private ExpressionNode parseTerm (RingelnatterParser.TermContext context){
        ExpressionNode leftOp = parseFactor(context.factor(0));

        if(context.factor().size() == 1)
            return leftOp;

        for (int i = 1; i < context.factor().size(); i++) {
            ExpressionNode rightOp = parseFactor(context.factor(i));
            leftOp = createBinary(context.op.getText(), leftOp, rightOp);
        }
        return leftOp;
    }

    private ExpressionNode parseFactor(RingelnatterParser.FactorContext context) {
        if (context.factor() != null){
            return parseUnaryOperator(context);
        } else if (context.NUMERIC_LITERAL() != null) {
            return new LongValueNode(Long.parseLong(context.NUMERIC_LITERAL().getText()));
        } else if (context.var != null) {
            verifyExistenceOfLocal(lexicalScope, context.var);
            FrameSlot slot = frameDescriptor.findFrameSlot(context.var.getText());
            return ReadLocalVariableNodeGen.create(slot);
        } else if (context.target != null) {
            int argsize = context.expression().size();
            ExpressionNode[] arguments = new ExpressionNode[argsize];
            for (int i = 0; i < argsize; i++) {
                arguments[i] = parseExpression(context.expression(i));
            }
            return new InvokeNode(context.target.getText(), arguments);
        } else if (context.expression() != null) {
            return parseExpression(context.expression(0));
        }

        throw new UnsupportedOperationException("Factor could not be parsed");
    }

    private ExpressionNode parseUnaryOperator(RingelnatterParser.FactorContext context) {
        String op = context.op.getText();
        ExpressionNode inner = parseFactor(context.factor());
        switch (op){
            case "!": return NotNodeGen.create(inner);
            case "is": return IsNodeGen.create(context.typename().getText(), inner);
        }
        throw new UnsupportedOperationException("Operator " + op + " not supported");
    }

    private ExpressionNode createBinary (String op, ExpressionNode leftOp, ExpressionNode rightOp){
        switch (op){
            case "+": return AddNodeGen.create(leftOp, rightOp);
            case "-": return SubtractNodeGen.create(leftOp, rightOp);
            case "*": return MultiplyNodeGen.create(leftOp, rightOp);
            case "/": return DivideNodeGen.create(leftOp, rightOp);
            case "%": return ModuloNodeGen.create(leftOp, rightOp);
            case "==": return EqualsNodeGen.create(leftOp, rightOp);
            case "!=": return NotNodeGen.create(EqualsNodeGen.create(leftOp, rightOp));
            case "<": return LessThanNodeGen.create(leftOp, rightOp);
            case "<=": return LessThanOrEqualNodeGen.create(leftOp, rightOp);
            case ">": return NotNodeGen.create(LessThanOrEqualNodeGen.create(leftOp, rightOp));
            case ">=": return NotNodeGen.create(LessThanNodeGen.create(leftOp, rightOp));
            case "&&": return AndLogicNodeGen.create(leftOp, rightOp);
            case "||": return OrNodeGen.create(leftOp, rightOp);
        }
        throw new UnsupportedOperationException("Operator " + op + " not supported");
    }

    private void verifyExistenceOfLocal(LexicalScope scope, Token identifier) {
        verifyExistenceOfLocal(scope, identifier, true);
    }

    private void verifyNonExistenceOfLocal(LexicalScope scope, Token identifier) {
        verifyExistenceOfLocal(scope, identifier, false);
    }

    private void verifyExistenceOfLocal(LexicalScope scope, Token identifier, boolean shouldExist) {
        if (scope.locals.containsKey(identifier.getText()) != shouldExist) {
            int beginChar = identifier.getCharPositionInLine();
            int endChar = beginChar + identifier.getText().length();
            String reason = shouldExist ? " does not exist" : " was already defined";
            throw new RingelnatterParseError(source, identifier.getLine(), beginChar, endChar, "The local variable '" + identifier.getText() + "' " + reason + ".");
        }
    }

    private WriteLocalVariableNode createLocalVariable(String variableName, ExpressionNode value) {
        FrameSlot frameSlot = frameDescriptor.addFrameSlot(variableName, FrameSlotKind.Illegal);
        WriteLocalVariableNode writeLocalVariableNode = WriteLocalVariableNodeGen.create(value, frameSlot);
        lexicalScope.locals.put(variableName, frameSlot);
        return writeLocalVariableNode;
    }

    private FrameSlot getLocalVariable(Token identifier) {
        verifyExistenceOfLocal(lexicalScope, identifier);
        return frameDescriptor.findFrameSlot(identifier.getText());
    }
}
