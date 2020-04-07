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
import org.antlr.v4.runtime.Token;
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

    private Map<String, RootCallTarget> callTargets;
    private Source source;
    private final RingelnatterLanguage language;
    private final RingelnatterParser parser;

    // state for function
    private LexicalScope lexicalScope;
    private FrameDescriptor frameDescriptor;
    private List<StatementNode> statementNodes;

    // state for suites
    private Stack<List<StatementNode>> suites;
    private SuiteNode lastExitedSuite;

    public RingelnatterTruffleListener(RingelnatterLanguage language, Source source, RingelnatterParser parser) {
        this.source = source;
        this.language = language;
        this.parser = parser;
        callTargets = new HashMap<>();
    }

    public Map<String, RootCallTarget> getCallTargets() {
        return callTargets;
    }

    @Override
    public void enterFunction(RingelnatterParser.FunctionContext ctx) {
        List<TerminalNode> identifiers = ctx.IDENTIFIER();
        lexicalScope = new LexicalScope(null);
        frameDescriptor = new FrameDescriptor();
        statementNodes = new LinkedList<>();
        suites = new Stack<>();

        // assert no duplicate function

        for (int i = 1; i < identifiers.size(); i++) {
            String parameterName = identifiers.get(i).getText();
            ReadArgumentNode readArgumentNode = new ReadArgumentNode(i - 1);
            WriteLocalVariableNode writeLocalVariableNode = createLocalVariable(parameterName, readArgumentNode);
            statementNodes.add(writeLocalVariableNode);
        }
        super.enterFunction(ctx);
    }

    @Override
    public void exitFunction(RingelnatterParser.FunctionContext ctx) {
        statementNodes.add(lastExitedSuite);

        String functionName = ctx.IDENTIFIER(0).getText();
        FunctionBodyNode body = new FunctionBodyNode(new SuiteNode(statementNodes.toArray(new StatementNode[0])));
        RingelnatterRootNode rootNode = new RingelnatterRootNode(language, frameDescriptor, functionName, body);
        callTargets.put(functionName, Truffle.getRuntime().createCallTarget(rootNode));

        lexicalScope = null;
        frameDescriptor = null;
        statementNodes = null;
        lastExitedSuite = null;
    }

    @Override
    public void enterSuite(RingelnatterParser.SuiteContext ctx) {
        System.out.println("enterSuite");
        lexicalScope = new LexicalScope(lexicalScope);
        suites.push(new LinkedList<>());
    }

    @Override
    public void exitSuite(RingelnatterParser.SuiteContext ctx) {
        System.out.println("exitSuite");
        lexicalScope = lexicalScope.outer;

        List<StatementNode> nodes = suites.pop();
        SuiteNode suite = new SuiteNode(nodes.toArray(new StatementNode[0]));
        if(suites.size() > 0) {
            suites.peek().add(suite);
        }else {
            lastExitedSuite = suite;
        }
    }

    @Override
    public void exitStmnt(RingelnatterParser.StmntContext ctx) {
        List<StatementNode> currentSuite = suites.peek();
        if(ctx.start.getText().equals("ret")) {
            currentSuite.add(new ReturnNode(parseExpression(ctx.expression())));
        } else if(ctx.start.getText().equals("let")) {
            verifyNonExistenceOfLocal(lexicalScope, ctx.IDENTIFIER());
            currentSuite.add(createLocalVariable(ctx.IDENTIFIER().getText(), parseExpression(ctx.expression())));
        }
    }

    private ExpressionNode parseExpression(RingelnatterParser.ExpressionContext context) {
        return parseLogicalTerm(context.logical_term());
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

    private ExpressionNode parseFactor(RingelnatterParser.FactorContext context) {
        if (context.NUMERIC_LITERAL() != null) {
            return new LongValueNode(Long.parseLong(context.NUMERIC_LITERAL().getText()));
        } else if (context.IDENTIFIER() != null) {
            verifyExistenceOfLocal(lexicalScope, context.IDENTIFIER());
            FrameSlot slot = frameDescriptor.findFrameSlot(context.IDENTIFIER().getText());
            return ReadLocalVariableNodeGen.create(slot);
        } else if (context.expression() != null) {
            return parseExpression(context.expression());
        }

        throw new UnsupportedOperationException("Factor could not be parsed");
    }

    private void verifyExistenceOfLocal(LexicalScope scope, TerminalNode node) {
        verifyExistenceOfLocal(scope, node, true);
    }

    private void verifyNonExistenceOfLocal(LexicalScope scope, TerminalNode node) {
        verifyExistenceOfLocal(scope, node, false);
    }

    private void verifyExistenceOfLocal(LexicalScope scope, TerminalNode node, boolean shouldExist) {
        if (scope.locals.containsKey(node.getText()) != shouldExist) {
            Token symbol = node.getSymbol();
            int beginChar = symbol.getCharPositionInLine();
            int endChar = beginChar + node.getText().length();
            String reason = shouldExist ? " does not exist" : " was already defined";
            throw new RingelnatterParseError(source, symbol.getLine(), beginChar, endChar, "The local variable '" + node.getText() + "' " + reason + ".");
        }
    }

    private WriteLocalVariableNode createLocalVariable(String parameterName, ExpressionNode readArgumentNode) {
        FrameSlot frameSlot = frameDescriptor.addFrameSlot(parameterName, FrameSlotKind.Illegal);
        WriteLocalVariableNode writeLocalVariableNode = WriteLocalVariableNodeGen.create(readArgumentNode, frameSlot);
        lexicalScope.locals.put(parameterName, frameSlot);
        return writeLocalVariableNode;
    }
}
