// Generated from language/src/main/java/com/oracle/truffle/sl/parser/Ringelnatter.g4 by ANTLR 4.7.1
package com.oracle.truffle.sl.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RingelnatterParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RingelnatterVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RingelnatterParser#ringelnatter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRingelnatter(RingelnatterParser.RingelnatterContext ctx);
	/**
	 * Visit a parse tree produced by {@link RingelnatterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(RingelnatterParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RingelnatterParser#arithmetic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmetic(RingelnatterParser.ArithmeticContext ctx);
	/**
	 * Visit a parse tree produced by {@link RingelnatterParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(RingelnatterParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link RingelnatterParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(RingelnatterParser.FactorContext ctx);
}