// Generated from language/src/main/java/com/oracle/truffle/sl/parser/Ringelnatter.g4 by ANTLR 4.7.1
package com.oracle.truffle.sl.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RingelnatterParser}.
 */
public interface RingelnatterListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RingelnatterParser#ringelnatter}.
	 * @param ctx the parse tree
	 */
	void enterRingelnatter(RingelnatterParser.RingelnatterContext ctx);
	/**
	 * Exit a parse tree produced by {@link RingelnatterParser#ringelnatter}.
	 * @param ctx the parse tree
	 */
	void exitRingelnatter(RingelnatterParser.RingelnatterContext ctx);
	/**
	 * Enter a parse tree produced by {@link RingelnatterParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(RingelnatterParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RingelnatterParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(RingelnatterParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RingelnatterParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterSuite(RingelnatterParser.SuiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link RingelnatterParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitSuite(RingelnatterParser.SuiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link RingelnatterParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void enterStmnt(RingelnatterParser.StmntContext ctx);
	/**
	 * Exit a parse tree produced by {@link RingelnatterParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void exitStmnt(RingelnatterParser.StmntContext ctx);
	/**
	 * Enter a parse tree produced by {@link RingelnatterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(RingelnatterParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RingelnatterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(RingelnatterParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RingelnatterParser#arithmetic}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic(RingelnatterParser.ArithmeticContext ctx);
	/**
	 * Exit a parse tree produced by {@link RingelnatterParser#arithmetic}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic(RingelnatterParser.ArithmeticContext ctx);
	/**
	 * Enter a parse tree produced by {@link RingelnatterParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(RingelnatterParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link RingelnatterParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(RingelnatterParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link RingelnatterParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(RingelnatterParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link RingelnatterParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(RingelnatterParser.FactorContext ctx);
}