package com.oracle.truffle.sl.parser;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.sl.FunctionBodyNode;
import com.oracle.truffle.sl.RingelnatterLanguage;
import com.oracle.truffle.sl.RingelnatterRootNode;
import com.oracle.truffle.sl.matching.*;
import com.oracle.truffle.sl.nodes.*;
import com.oracle.truffle.sl.nodes.expression.*;
import com.oracle.truffle.sl.runtime.RingelnatterFunctionRegistry;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class RingelnatterTruffleListener extends RingelnatterBaseListener {
    @FunctionalInterface
    private interface SuiteFinalizer {
        void finalize(SuiteNode suiteNode);
    }

    private class SuiteCollector implements SuiteFinalizer {
        private List<SuiteNode> suites = new LinkedList<>();

        @Override
        public void finalize(SuiteNode suiteNode) {
            suites.add(suiteNode);
        }

        public List<SuiteNode> getSuites() {
            return suites;
        }

        public SuiteNode getSuite() {
            assert suites.size() == 1;
            return suites.get(0);
        }
    }

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

        for (int i = 1; i < identifiers.size(); i++) {
            Token symbol = identifiers.get(i).getSymbol();
            ReadArgumentNode readArgumentNode = new ReadArgumentNode(i - 1);
            WriteLocalVariableNode writeLocalVariableNode = createLocalVariable(symbol, readArgumentNode);
            statementNodes.add(writeLocalVariableNode);
        }
    }

    @Override
    public void exitFunction(RingelnatterParser.FunctionContext ctx) {
        String functionName = ctx.IDENTIFIER(0).getText();
        statementNodes.add(parseSuite(ctx.suite()));
        FunctionBodyNode body = new FunctionBodyNode(new SuiteNode(statementNodes.toArray(new StatementNode[0])));
        RingelnatterRootNode rootNode = new RingelnatterRootNode(language, frameDescriptor, functionName, body);
        functionRegistry.register(functionName, ctx.IDENTIFIER().size() - 1, Truffle.getRuntime().createCallTarget(rootNode));

        lexicalScope = null;
        frameDescriptor = null;
        statementNodes = null;
    }

    public SuiteNode parseSuite(RingelnatterParser.SuiteContext ctx) {
        LinkedList<StatementNode> statementNodes = new LinkedList<>();
        for (int i = 0; i < ctx.stmnt().size(); i++) {
            statementNodes.add(parseStatement(ctx.stmnt(i)));
        }
        return new SuiteNode(statementNodes.toArray(new StatementNode[0]));
    }

    public StatementNode parseStatement(RingelnatterParser.StmntContext ctx) {
        if (ctx.start.getText().equals("ret")) {
            return new ReturnNode(parseMultilineExpression(ctx.multilineexpression()));
        } else if (ctx.start.getText().equals("let")) {
            return createLocalVariable(ctx.IDENTIFIER().getSymbol(), parseMultilineExpression(ctx.multilineexpression()));
        } else if (ctx.start.getText().equals("if")) {
            return parseIfStatement(ctx);
        } else if (ctx.start.getText().equals("while")) {
            ExpressionNode conditionalExpression = parseExpression(ctx.expression(0));
            return new WhileNode(ConditionalNodeGen.create(conditionalExpression), parseSuite(ctx.suite(0)));
        } else if (ctx.var != null) {
            ExpressionNode expression = parseMultilineExpression(ctx.multilineexpression());
            FrameSlot frameSlot = getLocalVariable(ctx.var);
            return WriteLocalVariableNodeGen.create(expression, frameSlot);
        } else {
            throw new UnsupportedOperationException("Statement unknown");
        }
    }

    private StatementNode parseIfStatement(RingelnatterParser.StmntContext ctx) {
        return constructIfStatement(ctx.expression(), ctx.suite());
    }

    private StatementNode constructIfStatement(List<RingelnatterParser.ExpressionContext> expression, List<RingelnatterParser.SuiteContext> suites) {
        if (expression.size() == 0)
            return suites.size() == 1 ? parseSuite(suites.get(0)) : null; // else block

        StatementNode innerNode = constructIfStatement(expression.subList(1, expression.size()), suites.subList(1, suites.size()));
        ExpressionNode conditionalExpression = parseExpression(expression.get(0));
        return new IfNode(ConditionalNodeGen.create(conditionalExpression), parseSuite(suites.get(0)), innerNode);
    }

    private ExpressionNode parseMultilineExpression(RingelnatterParser.MultilineexpressionContext ctx) {
        if (ctx.evalexpression() != null)
            return parseEvalExpression(ctx.evalexpression());
        return parseExpression(ctx.expression());
    }

    private ExpressionNode parseExpression(RingelnatterParser.ExpressionContext ctx) {
        if (ctx.logical_term() != null) {
            return parseLogicalTerm(ctx.logical_term());
        } else if (ctx.factor().size() > 0) {
            return parseConcatenation(ctx.factor());
        }
        throw new UnsupportedOperationException("Cannot parse this kind of expression");
    }

    private ExpressionNode parseEvalExpression(RingelnatterParser.EvalexpressionContext evalexpression) {
        LinkedList<EvalArmNode> arms = new LinkedList<>();
        for (int i = 0; i < evalexpression.arm().size(); i++) {
            arms.add(parseArm(evalexpression.arm(i)));
        }
        return new EvalNode(arms.toArray(new EvalArmNode[0]));
    }

    private EvalArmNode parseArm(RingelnatterParser.ArmContext ctx) {
        lexicalScope = new LexicalScope(lexicalScope);
        ExpressionNode guard = ctx.guard != null ? parseExpression(ctx.guard) : new LongValueNode(1);
        ExpressionNode value = parseExpression(ctx.value);
        lexicalScope = lexicalScope.outer;
        return new EvalArmNode(ConditionalNodeGen.create(guard), value);
    }

    private ExpressionNode parseConcatenation(List<RingelnatterParser.FactorContext> factors) {
        LinkedList<ExpressionNode> list = new LinkedList<>();
        for (RingelnatterParser.FactorContext factor : factors)
            list.add(parseFactor(factor));
        return new ConcatNode(list.toArray(new ExpressionNode[0]));
    }

    private ExpressionNode parseLogicalTerm(RingelnatterParser.Logical_termContext ctx) {
        ExpressionNode leftOp = parseLogicalFactor(ctx.logical_factor(0));

        if (ctx.logical_factor().size() == 1)
            return leftOp;

        for (int i = 1; i < ctx.logical_factor().size(); i++) {
            ExpressionNode rightOp = parseLogicalFactor(ctx.logical_factor(i));
            leftOp = createBinary(ctx.op.getText(), leftOp, rightOp);
        }
        return leftOp;
    }

    private ExpressionNode parseLogicalFactor(RingelnatterParser.Logical_factorContext ctx) {
        ExpressionNode leftOp = parseArithmetic(ctx.arithmetic(0));

        if (ctx.arithmetic().size() == 1)
            return leftOp;

        for (int i = 1; i < ctx.arithmetic().size(); i++) {
            ExpressionNode rightOp = parseArithmetic(ctx.arithmetic(i));
            leftOp = createBinary(ctx.op.getText(), leftOp, rightOp);
        }
        return leftOp;
    }

    private ExpressionNode parseArithmetic(RingelnatterParser.ArithmeticContext ctx) {
        ExpressionNode leftOp = parseTerm(ctx.term(0));

        if (ctx.term().size() == 1)
            return leftOp;

        for (int i = 1; i < ctx.term().size(); i++) {
            ExpressionNode rightOp = parseTerm(ctx.term(i));
            leftOp = createBinary(ctx.op.getText(), leftOp, rightOp);
        }
        return leftOp;
    }

    private ExpressionNode parseTerm(RingelnatterParser.TermContext ctx) {
        ExpressionNode leftOp = parseFactor(ctx.factor(0));

        if (ctx.factor().size() == 1)
            return leftOp;

        for (int i = 1; i < ctx.factor().size(); i++) {
            ExpressionNode rightOp = parseFactor(ctx.factor(i));
            leftOp = createBinary(ctx.op.getText(), leftOp, rightOp);
        }
        return leftOp;
    }

    private ExpressionNode parseFactor(RingelnatterParser.FactorContext ctx) {
        if (ctx.factor() != null) {
            return parseUnaryOperator(ctx);
        } else if (ctx.NUMERIC_LITERAL() != null) {
            return new LongValueNode(Long.parseLong(ctx.NUMERIC_LITERAL().getText()));
        } else if (ctx.listfactor() != null) {
            return parseListFactor(ctx.listfactor());
        } else if (ctx.var != null) {
            verifyExistenceOfLocal(lexicalScope, ctx.var);
            FrameSlot slot = frameDescriptor.findFrameSlot(ctx.var.getText());
            return ReadLocalVariableNodeGen.create(slot);
        } else if (ctx.target != null) {
            int argsize = ctx.expression().size();
            ExpressionNode[] arguments = new ExpressionNode[argsize];
            for (int i = 0; i < argsize; i++) {
                arguments[i] = parseExpression(ctx.expression(i));
            }
            return new InvokeNode(ctx.target.getText(), arguments);
        } else if (ctx.expression() != null) {
            return parseExpression(ctx.expression(0));
        }

        throw new UnsupportedOperationException("Factor could not be parsed");
    }

    private ExpressionNode parseListFactor(RingelnatterParser.ListfactorContext ctx) {
        LinkedList<ExpressionNode> list = new LinkedList<>();
        for (RingelnatterParser.ExpressionContext element : ctx.expression())
            list.add(parseExpression(element));
        return new ListNode(list.toArray(new ExpressionNode[0]));
    }

    private ExpressionNode parseUnaryOperator(RingelnatterParser.FactorContext ctx) {
        String op = ctx.op.getText();
        ExpressionNode inner = parseFactor(ctx.factor());
        switch (op) {
            case "!":
                return NotNodeGen.create(inner);
            case "is":
                return IsNodeGen.create(ctx.typename().getText(), inner);
            case "matches":
                return new MatchesNode(parseMatcher(ctx.matchexpr()), inner);
        }
        throw new UnsupportedOperationException("Operator " + op + " not supported");
    }

    private Matcher parseMatcher(RingelnatterParser.MatchexprContext ctx) {
        if (ctx.NUMERIC_LITERAL() != null)
            return new NumberLiteralMatcher(Long.parseLong(ctx.NUMERIC_LITERAL().getText()));
        if (ctx.IDENTIFIER() != null) {
            findOrAddFrameSlot(ctx.IDENTIFIER().getSymbol());
            return new AnyMatcher(getLocalVariable(ctx.IDENTIFIER().getSymbol()));
        }
        return parseListMatcher(ctx.listmatchexpr());
    }

    private Matcher parseListMatcher(RingelnatterParser.ListmatchexprContext ctx) {
        if (ctx.listmatchelementexpr().size() == 0)
            return new EmptyListMatcher();
        if (ctx.listmatchelementexpr().size() == 1) {
            return new SingleElementListMatcher(parseListElementMatcher(ctx.listmatchelementexpr(0)));
        }

        LinkedList<Matcher> matchers = new LinkedList<>();
        for (RingelnatterParser.ListmatchelementexprContext elementContext : ctx.listmatchelementexpr()) {
            matchers.add(parseListElementMatcher(elementContext));
        }
        return new ListMatcher(matchers);
    }

    private Matcher parseListElementMatcher(RingelnatterParser.ListmatchelementexprContext ctx) {
        if (ctx.IDENTIFIER() != null) {
            findOrAddFrameSlot(ctx.IDENTIFIER().getSymbol());
            return new AnyMatcher(getLocalVariable(ctx.IDENTIFIER().getSymbol()));
        }
        return parseMatcher(ctx.matchexpr());
    }

    private ExpressionNode createBinary(String op, ExpressionNode leftOp, ExpressionNode rightOp) {
        switch (op) {
            case "+":
                return AddNodeGen.create(leftOp, rightOp);
            case "-":
                return SubtractNodeGen.create(leftOp, rightOp);
            case "*":
                return MultiplyNodeGen.create(leftOp, rightOp);
            case "/":
                return DivideNodeGen.create(leftOp, rightOp);
            case "%":
                return ModuloNodeGen.create(leftOp, rightOp);
            case "==":
                return EqualsNodeGen.create(leftOp, rightOp);
            case "!=":
                return NotNodeGen.create(EqualsNodeGen.create(leftOp, rightOp));
            case "<":
                return LessThanNodeGen.create(leftOp, rightOp);
            case "<=":
                return LessThanOrEqualNodeGen.create(leftOp, rightOp);
            case ">":
                return NotNodeGen.create(LessThanOrEqualNodeGen.create(leftOp, rightOp));
            case ">=":
                return NotNodeGen.create(LessThanNodeGen.create(leftOp, rightOp));
            case "&&":
                return AndLogicNodeGen.create(leftOp, rightOp);
            case "||":
                return OrNodeGen.create(leftOp, rightOp);
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

    private FrameSlot findOrAddFrameSlot(Token identifier) {
        String variableName = identifier.getText();
        FrameSlot frameSlot = frameDescriptor.findOrAddFrameSlot(variableName, FrameSlotKind.Illegal);
        lexicalScope.locals.put(variableName, frameSlot);
        return frameSlot;
    }

    private WriteLocalVariableNode createLocalVariable(Token identifier, ExpressionNode value) {
        verifyNonExistenceOfLocal(lexicalScope, identifier);
        return WriteLocalVariableNodeGen.create(value, findOrAddFrameSlot(identifier));
    }

    private FrameSlot getLocalVariable(Token identifier) {
        verifyExistenceOfLocal(lexicalScope, identifier);
        return frameDescriptor.findFrameSlot(identifier.getText());
    }
}
