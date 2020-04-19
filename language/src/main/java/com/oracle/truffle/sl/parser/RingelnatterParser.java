// Generated from language/src/main/java/com/oracle/truffle/sl/parser/Ringelnatter.g4 by ANTLR 4.7.1
package com.oracle.truffle.sl.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RingelnatterParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, LINE_COMMENT=33, IDENTIFIER=34, NUMERIC_LITERAL=35, WS=36, NEWLINE=37, 
		INDENT=38, DEDENT=39;
	public static final int
		RULE_ringelnatter = 0, RULE_function = 1, RULE_suite = 2, RULE_stmnt = 3, 
		RULE_expression = 4, RULE_logical_term = 5, RULE_logical_factor = 6, RULE_arithmetic = 7, 
		RULE_term = 8, RULE_factor = 9, RULE_listfactor = 10, RULE_matchexpr = 11, 
		RULE_listmatchexpr = 12, RULE_listmatchelementexpr = 13, RULE_typename = 14;
	public static final String[] ruleNames = {
		"ringelnatter", "function", "suite", "stmnt", "expression", "logical_term", 
		"logical_factor", "arithmetic", "term", "factor", "listfactor", "matchexpr", 
		"listmatchexpr", "listmatchelementexpr", "typename"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'fn'", "'('", "','", "'):'", "'='", "'let'", "'ret'", "'if'", "':'", 
		"'while'", "'.'", "'&&'", "'||'", "'=='", "'!='", "'>'", "'<'", "'>='", 
		"'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'is'", "'matches'", 
		"')'", "'['", "']'", "'number'", "'list'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "LINE_COMMENT", 
		"IDENTIFIER", "NUMERIC_LITERAL", "WS", "NEWLINE", "INDENT", "DEDENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Ringelnatter.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }




	public RingelnatterParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RingelnatterContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(RingelnatterParser.EOF, 0); }
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(RingelnatterParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RingelnatterParser.NEWLINE, i);
		}
		public RingelnatterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ringelnatter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).enterRingelnatter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).exitRingelnatter(this);
		}
	}

	public final RingelnatterContext ringelnatter() throws RecognitionException {
		RingelnatterContext _localctx = new RingelnatterContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_ringelnatter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==NEWLINE) {
				{
				setState(32);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(30);
					function();
					}
					break;
				case NEWLINE:
					{
					setState(31);
					match(NEWLINE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(RingelnatterParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(RingelnatterParser.IDENTIFIER, i);
		}
		public TerminalNode NEWLINE() { return getToken(RingelnatterParser.NEWLINE, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(T__0);
			setState(40);
			match(IDENTIFIER);
			setState(41);
			match(T__1);
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(42);
				match(IDENTIFIER);
				}
			}

			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(45);
				match(T__2);
				setState(46);
				match(IDENTIFIER);
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
			match(T__3);
			setState(53);
			match(NEWLINE);
			setState(54);
			suite();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuiteContext extends ParserRuleContext {
		public TerminalNode INDENT() { return getToken(RingelnatterParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(RingelnatterParser.DEDENT, 0); }
		public List<StmntContext> stmnt() {
			return getRuleContexts(StmntContext.class);
		}
		public StmntContext stmnt(int i) {
			return getRuleContext(StmntContext.class,i);
		}
		public SuiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).enterSuite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).exitSuite(this);
		}
	}

	public final SuiteContext suite() throws RecognitionException {
		SuiteContext _localctx = new SuiteContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_suite);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(INDENT);
			setState(58); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(57);
				stmnt();
				}
				}
				setState(60); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << IDENTIFIER))) != 0) );
			setState(62);
			match(DEDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmntContext extends ParserRuleContext {
		public Token var;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(RingelnatterParser.NEWLINE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(RingelnatterParser.IDENTIFIER, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public StmntContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmnt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).enterStmnt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).exitStmnt(this);
		}
	}

	public final StmntContext stmnt() throws RecognitionException {
		StmntContext _localctx = new StmntContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_stmnt);
		try {
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				((StmntContext)_localctx).var = match(IDENTIFIER);
				setState(65);
				match(T__4);
				setState(66);
				expression();
				setState(67);
				match(NEWLINE);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				match(T__5);
				setState(70);
				((StmntContext)_localctx).var = match(IDENTIFIER);
				setState(71);
				match(T__4);
				setState(72);
				expression();
				setState(73);
				match(NEWLINE);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				match(T__6);
				setState(76);
				expression();
				setState(77);
				match(NEWLINE);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				match(T__7);
				setState(80);
				expression();
				setState(81);
				match(T__8);
				setState(82);
				match(NEWLINE);
				setState(83);
				suite();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(85);
				match(T__9);
				setState(86);
				expression();
				setState(87);
				match(T__8);
				setState(88);
				match(NEWLINE);
				setState(89);
				suite();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Logical_termContext logical_term() {
			return getRuleContext(Logical_termContext.class,0);
		}
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expression);
		int _la;
		try {
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				logical_term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				factor(0);
				setState(97); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(95);
					match(T__10);
					setState(96);
					factor(0);
					}
					}
					setState(99); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__10 );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Logical_termContext extends ParserRuleContext {
		public Token op;
		public List<Logical_factorContext> logical_factor() {
			return getRuleContexts(Logical_factorContext.class);
		}
		public Logical_factorContext logical_factor(int i) {
			return getRuleContext(Logical_factorContext.class,i);
		}
		public Logical_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).enterLogical_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).exitLogical_term(this);
		}
	}

	public final Logical_termContext logical_term() throws RecognitionException {
		Logical_termContext _localctx = new Logical_termContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_logical_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			logical_factor();
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11 || _la==T__12) {
				{
				{
				setState(104);
				((Logical_termContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__11 || _la==T__12) ) {
					((Logical_termContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(105);
				logical_factor();
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Logical_factorContext extends ParserRuleContext {
		public Token op;
		public List<ArithmeticContext> arithmetic() {
			return getRuleContexts(ArithmeticContext.class);
		}
		public ArithmeticContext arithmetic(int i) {
			return getRuleContext(ArithmeticContext.class,i);
		}
		public Logical_factorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).enterLogical_factor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).exitLogical_factor(this);
		}
	}

	public final Logical_factorContext logical_factor() throws RecognitionException {
		Logical_factorContext _localctx = new Logical_factorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_logical_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			arithmetic();
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18))) != 0)) {
				{
				{
				setState(112);
				((Logical_factorContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18))) != 0)) ) {
					((Logical_factorContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(113);
				arithmetic();
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithmeticContext extends ParserRuleContext {
		public Token op;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public ArithmeticContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).enterArithmetic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).exitArithmetic(this);
		}
	}

	public final ArithmeticContext arithmetic() throws RecognitionException {
		ArithmeticContext _localctx = new ArithmeticContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arithmetic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			term();
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19 || _la==T__20) {
				{
				{
				setState(120);
				((ArithmeticContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__19 || _la==T__20) ) {
					((ArithmeticContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(121);
				term();
				}
				}
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public Token op;
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			factor(0);
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23))) != 0)) {
				{
				{
				setState(128);
				((TermContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23))) != 0)) ) {
					((TermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(129);
				factor(0);
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public Token op;
		public Token var;
		public Token target;
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode NUMERIC_LITERAL() { return getToken(RingelnatterParser.NUMERIC_LITERAL, 0); }
		public ListfactorContext listfactor() {
			return getRuleContext(ListfactorContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(RingelnatterParser.IDENTIFIER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public MatchexprContext matchexpr() {
			return getRuleContext(MatchexprContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		return factor(0);
	}

	private FactorContext factor(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FactorContext _localctx = new FactorContext(_ctx, _parentState);
		FactorContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_factor, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(136);
				((FactorContext)_localctx).op = match(T__24);
				setState(137);
				factor(8);
				}
				break;
			case 2:
				{
				setState(138);
				match(NUMERIC_LITERAL);
				}
				break;
			case 3:
				{
				setState(139);
				listfactor();
				}
				break;
			case 4:
				{
				setState(140);
				((FactorContext)_localctx).var = match(IDENTIFIER);
				}
				break;
			case 5:
				{
				setState(141);
				match(T__1);
				setState(142);
				expression();
				setState(143);
				match(T__27);
				}
				break;
			case 6:
				{
				setState(145);
				((FactorContext)_localctx).target = match(IDENTIFIER);
				setState(146);
				match(T__1);
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__24) | (1L << T__28) | (1L << IDENTIFIER) | (1L << NUMERIC_LITERAL))) != 0)) {
					{
					setState(147);
					expression();
					}
				}

				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(150);
					match(T__2);
					setState(151);
					expression();
					}
					}
					setState(156);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(157);
				match(T__27);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(168);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(166);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new FactorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_factor);
						setState(160);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(161);
						((FactorContext)_localctx).op = match(T__25);
						setState(162);
						typename();
						}
						break;
					case 2:
						{
						_localctx = new FactorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_factor);
						setState(163);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(164);
						((FactorContext)_localctx).op = match(T__26);
						setState(165);
						matchexpr();
						}
						break;
					}
					} 
				}
				setState(170);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ListfactorContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ListfactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listfactor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).enterListfactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).exitListfactor(this);
		}
	}

	public final ListfactorContext listfactor() throws RecognitionException {
		ListfactorContext _localctx = new ListfactorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_listfactor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(T__28);
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__24) | (1L << T__28) | (1L << IDENTIFIER) | (1L << NUMERIC_LITERAL))) != 0)) {
				{
				setState(172);
				expression();
				}
			}

			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(175);
				match(T__2);
				setState(176);
				expression();
				}
				}
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(182);
			match(T__29);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MatchexprContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(RingelnatterParser.NUMERIC_LITERAL, 0); }
		public ListmatchexprContext listmatchexpr() {
			return getRuleContext(ListmatchexprContext.class,0);
		}
		public MatchexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).enterMatchexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).exitMatchexpr(this);
		}
	}

	public final MatchexprContext matchexpr() throws RecognitionException {
		MatchexprContext _localctx = new MatchexprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_matchexpr);
		try {
			setState(186);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMERIC_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				match(NUMERIC_LITERAL);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 2);
				{
				setState(185);
				listmatchexpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListmatchexprContext extends ParserRuleContext {
		public List<ListmatchelementexprContext> listmatchelementexpr() {
			return getRuleContexts(ListmatchelementexprContext.class);
		}
		public ListmatchelementexprContext listmatchelementexpr(int i) {
			return getRuleContext(ListmatchelementexprContext.class,i);
		}
		public ListmatchexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listmatchexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).enterListmatchexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).exitListmatchexpr(this);
		}
	}

	public final ListmatchexprContext listmatchexpr() throws RecognitionException {
		ListmatchexprContext _localctx = new ListmatchexprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_listmatchexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(T__28);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << IDENTIFIER) | (1L << NUMERIC_LITERAL))) != 0)) {
				{
				setState(189);
				listmatchelementexpr();
				}
			}

			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(192);
				match(T__10);
				setState(193);
				listmatchelementexpr();
				}
				}
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(199);
			match(T__29);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListmatchelementexprContext extends ParserRuleContext {
		public MatchexprContext matchexpr() {
			return getRuleContext(MatchexprContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(RingelnatterParser.IDENTIFIER, 0); }
		public ListmatchelementexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listmatchelementexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).enterListmatchelementexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).exitListmatchelementexpr(this);
		}
	}

	public final ListmatchelementexprContext listmatchelementexpr() throws RecognitionException {
		ListmatchelementexprContext _localctx = new ListmatchelementexprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_listmatchelementexpr);
		try {
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__28:
			case NUMERIC_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
				matchexpr();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypenameContext extends ParserRuleContext {
		public TypenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).enterTypename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).exitTypename(this);
		}
	}

	public final TypenameContext typename() throws RecognitionException {
		TypenameContext _localctx = new TypenameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_typename);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			_la = _input.LA(1);
			if ( !(_la==T__30 || _la==T__31) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return factor_sempred((FactorContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean factor_sempred(FactorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u00d2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\7\2#\n\2\f\2"+
		"\16\2&\13\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3.\n\3\3\3\3\3\7\3\62\n\3\f\3\16"+
		"\3\65\13\3\3\3\3\3\3\3\3\3\3\4\3\4\6\4=\n\4\r\4\16\4>\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5^\n\5\3\6\3\6\3\6\3\6\6\6d\n\6\r\6\16"+
		"\6e\5\6h\n\6\3\7\3\7\3\7\7\7m\n\7\f\7\16\7p\13\7\3\b\3\b\3\b\7\bu\n\b"+
		"\f\b\16\bx\13\b\3\t\3\t\3\t\7\t}\n\t\f\t\16\t\u0080\13\t\3\n\3\n\3\n\7"+
		"\n\u0085\n\n\f\n\16\n\u0088\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\5\13\u0097\n\13\3\13\3\13\7\13\u009b\n\13"+
		"\f\13\16\13\u009e\13\13\3\13\5\13\u00a1\n\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\7\13\u00a9\n\13\f\13\16\13\u00ac\13\13\3\f\3\f\5\f\u00b0\n\f\3\f"+
		"\3\f\7\f\u00b4\n\f\f\f\16\f\u00b7\13\f\3\f\3\f\3\r\3\r\5\r\u00bd\n\r\3"+
		"\16\3\16\5\16\u00c1\n\16\3\16\3\16\7\16\u00c5\n\16\f\16\16\16\u00c8\13"+
		"\16\3\16\3\16\3\17\3\17\5\17\u00ce\n\17\3\20\3\20\3\20\2\3\24\21\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36\2\7\3\2\16\17\3\2\20\25\3\2\26\27\3"+
		"\2\30\32\3\2!\"\2\u00e0\2$\3\2\2\2\4)\3\2\2\2\6:\3\2\2\2\b]\3\2\2\2\n"+
		"g\3\2\2\2\fi\3\2\2\2\16q\3\2\2\2\20y\3\2\2\2\22\u0081\3\2\2\2\24\u00a0"+
		"\3\2\2\2\26\u00ad\3\2\2\2\30\u00bc\3\2\2\2\32\u00be\3\2\2\2\34\u00cd\3"+
		"\2\2\2\36\u00cf\3\2\2\2 #\5\4\3\2!#\7\'\2\2\" \3\2\2\2\"!\3\2\2\2#&\3"+
		"\2\2\2$\"\3\2\2\2$%\3\2\2\2%\'\3\2\2\2&$\3\2\2\2\'(\7\2\2\3(\3\3\2\2\2"+
		")*\7\3\2\2*+\7$\2\2+-\7\4\2\2,.\7$\2\2-,\3\2\2\2-.\3\2\2\2.\63\3\2\2\2"+
		"/\60\7\5\2\2\60\62\7$\2\2\61/\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64"+
		"\3\2\2\2\64\66\3\2\2\2\65\63\3\2\2\2\66\67\7\6\2\2\678\7\'\2\289\5\6\4"+
		"\29\5\3\2\2\2:<\7(\2\2;=\5\b\5\2<;\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2"+
		"\2?@\3\2\2\2@A\7)\2\2A\7\3\2\2\2BC\7$\2\2CD\7\7\2\2DE\5\n\6\2EF\7\'\2"+
		"\2F^\3\2\2\2GH\7\b\2\2HI\7$\2\2IJ\7\7\2\2JK\5\n\6\2KL\7\'\2\2L^\3\2\2"+
		"\2MN\7\t\2\2NO\5\n\6\2OP\7\'\2\2P^\3\2\2\2QR\7\n\2\2RS\5\n\6\2ST\7\13"+
		"\2\2TU\7\'\2\2UV\5\6\4\2V^\3\2\2\2WX\7\f\2\2XY\5\n\6\2YZ\7\13\2\2Z[\7"+
		"\'\2\2[\\\5\6\4\2\\^\3\2\2\2]B\3\2\2\2]G\3\2\2\2]M\3\2\2\2]Q\3\2\2\2]"+
		"W\3\2\2\2^\t\3\2\2\2_h\5\f\7\2`c\5\24\13\2ab\7\r\2\2bd\5\24\13\2ca\3\2"+
		"\2\2de\3\2\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2\2\2g_\3\2\2\2g`\3\2\2\2h\13\3"+
		"\2\2\2in\5\16\b\2jk\t\2\2\2km\5\16\b\2lj\3\2\2\2mp\3\2\2\2nl\3\2\2\2n"+
		"o\3\2\2\2o\r\3\2\2\2pn\3\2\2\2qv\5\20\t\2rs\t\3\2\2su\5\20\t\2tr\3\2\2"+
		"\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\17\3\2\2\2xv\3\2\2\2y~\5\22\n\2z{\t"+
		"\4\2\2{}\5\22\n\2|z\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177"+
		"\21\3\2\2\2\u0080~\3\2\2\2\u0081\u0086\5\24\13\2\u0082\u0083\t\5\2\2\u0083"+
		"\u0085\5\24\13\2\u0084\u0082\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3"+
		"\2\2\2\u0086\u0087\3\2\2\2\u0087\23\3\2\2\2\u0088\u0086\3\2\2\2\u0089"+
		"\u008a\b\13\1\2\u008a\u008b\7\33\2\2\u008b\u00a1\5\24\13\n\u008c\u00a1"+
		"\7%\2\2\u008d\u00a1\5\26\f\2\u008e\u00a1\7$\2\2\u008f\u0090\7\4\2\2\u0090"+
		"\u0091\5\n\6\2\u0091\u0092\7\36\2\2\u0092\u00a1\3\2\2\2\u0093\u0094\7"+
		"$\2\2\u0094\u0096\7\4\2\2\u0095\u0097\5\n\6\2\u0096\u0095\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u009c\3\2\2\2\u0098\u0099\7\5\2\2\u0099\u009b\5\n"+
		"\6\2\u009a\u0098\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a1\7\36"+
		"\2\2\u00a0\u0089\3\2\2\2\u00a0\u008c\3\2\2\2\u00a0\u008d\3\2\2\2\u00a0"+
		"\u008e\3\2\2\2\u00a0\u008f\3\2\2\2\u00a0\u0093\3\2\2\2\u00a1\u00aa\3\2"+
		"\2\2\u00a2\u00a3\f\t\2\2\u00a3\u00a4\7\34\2\2\u00a4\u00a9\5\36\20\2\u00a5"+
		"\u00a6\f\b\2\2\u00a6\u00a7\7\35\2\2\u00a7\u00a9\5\30\r\2\u00a8\u00a2\3"+
		"\2\2\2\u00a8\u00a5\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\25\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00af\7\37\2"+
		"\2\u00ae\u00b0\5\n\6\2\u00af\u00ae\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b5"+
		"\3\2\2\2\u00b1\u00b2\7\5\2\2\u00b2\u00b4\5\n\6\2\u00b3\u00b1\3\2\2\2\u00b4"+
		"\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b8\3\2"+
		"\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b9\7 \2\2\u00b9\27\3\2\2\2\u00ba\u00bd"+
		"\7%\2\2\u00bb\u00bd\5\32\16\2\u00bc\u00ba\3\2\2\2\u00bc\u00bb\3\2\2\2"+
		"\u00bd\31\3\2\2\2\u00be\u00c0\7\37\2\2\u00bf\u00c1\5\34\17\2\u00c0\u00bf"+
		"\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c6\3\2\2\2\u00c2\u00c3\7\r\2\2\u00c3"+
		"\u00c5\5\34\17\2\u00c4\u00c2\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3"+
		"\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9"+
		"\u00ca\7 \2\2\u00ca\33\3\2\2\2\u00cb\u00ce\5\30\r\2\u00cc\u00ce\7$\2\2"+
		"\u00cd\u00cb\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce\35\3\2\2\2\u00cf\u00d0"+
		"\t\6\2\2\u00d0\37\3\2\2\2\31\"$-\63>]egnv~\u0086\u0096\u009c\u00a0\u00a8"+
		"\u00aa\u00af\u00b5\u00bc\u00c0\u00c6\u00cd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}