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
		T__24=25, LINE_COMMENT=26, IDENTIFIER=27, NUMERIC_LITERAL=28, WS=29, NEWLINE=30, 
		INDENT=31, DEDENT=32;
	public static final int
		RULE_ringelnatter = 0, RULE_function = 1, RULE_suite = 2, RULE_stmnt = 3, 
		RULE_expression = 4, RULE_logical_term = 5, RULE_logical_factor = 6, RULE_arithmetic = 7, 
		RULE_term = 8, RULE_factor = 9, RULE_typename = 10;
	public static final String[] ruleNames = {
		"ringelnatter", "function", "suite", "stmnt", "expression", "logical_term", 
		"logical_factor", "arithmetic", "term", "factor", "typename"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'fn'", "'('", "','", "'):'", "'let'", "'='", "'ret'", "'&&'", "'||'", 
		"'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", 
		"'%'", "'!'", "'is'", "')'", "'number'", "'list'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "LINE_COMMENT", "IDENTIFIER", "NUMERIC_LITERAL", "WS", "NEWLINE", 
		"INDENT", "DEDENT"
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
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==NEWLINE) {
				{
				setState(24);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(22);
					function();
					}
					break;
				case NEWLINE:
					{
					setState(23);
					match(NEWLINE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(29);
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
			setState(31);
			match(T__0);
			setState(32);
			match(IDENTIFIER);
			setState(33);
			match(T__1);
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(34);
				match(IDENTIFIER);
				}
			}

			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(37);
				match(T__2);
				setState(38);
				match(IDENTIFIER);
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44);
			match(T__3);
			setState(45);
			match(NEWLINE);
			setState(46);
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
		public List<TerminalNode> NEWLINE() { return getTokens(RingelnatterParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RingelnatterParser.NEWLINE, i);
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
			setState(48);
			match(INDENT);
			setState(52); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(49);
				stmnt();
				setState(50);
				match(NEWLINE);
				}
				}
				setState(54); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 || _la==T__6 );
			setState(56);
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
		public TerminalNode IDENTIFIER() { return getToken(RingelnatterParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
			setState(64);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				match(T__4);
				setState(59);
				match(IDENTIFIER);
				setState(60);
				match(T__5);
				setState(61);
				expression();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				match(T__6);
				setState(63);
				expression();
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			logical_term();
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
			setState(68);
			logical_factor();
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7 || _la==T__8) {
				{
				{
				setState(69);
				((Logical_termContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__7 || _la==T__8) ) {
					((Logical_termContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(70);
				logical_factor();
				}
				}
				setState(75);
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
			setState(76);
			arithmetic();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) {
				{
				{
				setState(77);
				((Logical_factorContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
					((Logical_factorContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(78);
				arithmetic();
				}
				}
				setState(83);
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
			setState(84);
			term();
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15 || _la==T__16) {
				{
				{
				setState(85);
				((ArithmeticContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__15 || _la==T__16) ) {
					((ArithmeticContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(86);
				term();
				}
				}
				setState(91);
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
			setState(92);
			factor(0);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) {
				{
				{
				setState(93);
				((TermContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) ) {
					((TermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(94);
				factor(0);
				}
				}
				setState(99);
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
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(101);
				((FactorContext)_localctx).op = match(T__20);
				setState(102);
				factor(6);
				}
				break;
			case 2:
				{
				setState(103);
				match(NUMERIC_LITERAL);
				}
				break;
			case 3:
				{
				setState(104);
				((FactorContext)_localctx).var = match(IDENTIFIER);
				}
				break;
			case 4:
				{
				setState(105);
				match(T__1);
				setState(106);
				expression();
				setState(107);
				match(T__22);
				}
				break;
			case 5:
				{
				setState(109);
				((FactorContext)_localctx).target = match(IDENTIFIER);
				setState(110);
				match(T__1);
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__20) | (1L << IDENTIFIER) | (1L << NUMERIC_LITERAL))) != 0)) {
					{
					setState(111);
					expression();
					}
				}

				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(114);
					match(T__2);
					setState(115);
					expression();
					}
					}
					setState(120);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(121);
				match(T__22);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(129);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new FactorContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_factor);
					setState(124);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(125);
					((FactorContext)_localctx).op = match(T__21);
					setState(126);
					typename();
					}
					} 
				}
				setState(131);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		enterRule(_localctx, 20, RULE_typename);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_la = _input.LA(1);
			if ( !(_la==T__23 || _la==T__24) ) {
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
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u0089\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\7\2\33\n\2\f\2\16\2\36\13\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\5\3&\n\3\3\3\3\3\7\3*\n\3\f\3\16\3-\13\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\6\4\67\n\4\r\4\16\48\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5C\n\5\3"+
		"\6\3\6\3\7\3\7\3\7\7\7J\n\7\f\7\16\7M\13\7\3\b\3\b\3\b\7\bR\n\b\f\b\16"+
		"\bU\13\b\3\t\3\t\3\t\7\tZ\n\t\f\t\16\t]\13\t\3\n\3\n\3\n\7\nb\n\n\f\n"+
		"\16\ne\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\5\13s\n\13\3\13\3\13\7\13w\n\13\f\13\16\13z\13\13\3\13\5\13}\n\13\3\13"+
		"\3\13\3\13\7\13\u0082\n\13\f\13\16\13\u0085\13\13\3\f\3\f\3\f\2\3\24\r"+
		"\2\4\6\b\n\f\16\20\22\24\26\2\7\3\2\n\13\3\2\f\21\3\2\22\23\3\2\24\26"+
		"\3\2\32\33\2\u008e\2\34\3\2\2\2\4!\3\2\2\2\6\62\3\2\2\2\bB\3\2\2\2\nD"+
		"\3\2\2\2\fF\3\2\2\2\16N\3\2\2\2\20V\3\2\2\2\22^\3\2\2\2\24|\3\2\2\2\26"+
		"\u0086\3\2\2\2\30\33\5\4\3\2\31\33\7 \2\2\32\30\3\2\2\2\32\31\3\2\2\2"+
		"\33\36\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35\37\3\2\2\2\36\34\3\2\2\2"+
		"\37 \7\2\2\3 \3\3\2\2\2!\"\7\3\2\2\"#\7\35\2\2#%\7\4\2\2$&\7\35\2\2%$"+
		"\3\2\2\2%&\3\2\2\2&+\3\2\2\2\'(\7\5\2\2(*\7\35\2\2)\'\3\2\2\2*-\3\2\2"+
		"\2+)\3\2\2\2+,\3\2\2\2,.\3\2\2\2-+\3\2\2\2./\7\6\2\2/\60\7 \2\2\60\61"+
		"\5\6\4\2\61\5\3\2\2\2\62\66\7!\2\2\63\64\5\b\5\2\64\65\7 \2\2\65\67\3"+
		"\2\2\2\66\63\3\2\2\2\678\3\2\2\28\66\3\2\2\289\3\2\2\29:\3\2\2\2:;\7\""+
		"\2\2;\7\3\2\2\2<=\7\7\2\2=>\7\35\2\2>?\7\b\2\2?C\5\n\6\2@A\7\t\2\2AC\5"+
		"\n\6\2B<\3\2\2\2B@\3\2\2\2C\t\3\2\2\2DE\5\f\7\2E\13\3\2\2\2FK\5\16\b\2"+
		"GH\t\2\2\2HJ\5\16\b\2IG\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\r\3\2\2"+
		"\2MK\3\2\2\2NS\5\20\t\2OP\t\3\2\2PR\5\20\t\2QO\3\2\2\2RU\3\2\2\2SQ\3\2"+
		"\2\2ST\3\2\2\2T\17\3\2\2\2US\3\2\2\2V[\5\22\n\2WX\t\4\2\2XZ\5\22\n\2Y"+
		"W\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\21\3\2\2\2][\3\2\2\2^c\5\24"+
		"\13\2_`\t\5\2\2`b\5\24\13\2a_\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\23"+
		"\3\2\2\2ec\3\2\2\2fg\b\13\1\2gh\7\27\2\2h}\5\24\13\bi}\7\36\2\2j}\7\35"+
		"\2\2kl\7\4\2\2lm\5\n\6\2mn\7\31\2\2n}\3\2\2\2op\7\35\2\2pr\7\4\2\2qs\5"+
		"\n\6\2rq\3\2\2\2rs\3\2\2\2sx\3\2\2\2tu\7\5\2\2uw\5\n\6\2vt\3\2\2\2wz\3"+
		"\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3\2\2\2{}\7\31\2\2|f\3\2\2\2|i"+
		"\3\2\2\2|j\3\2\2\2|k\3\2\2\2|o\3\2\2\2}\u0083\3\2\2\2~\177\f\7\2\2\177"+
		"\u0080\7\30\2\2\u0080\u0082\5\26\f\2\u0081~\3\2\2\2\u0082\u0085\3\2\2"+
		"\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\25\3\2\2\2\u0085\u0083"+
		"\3\2\2\2\u0086\u0087\t\6\2\2\u0087\27\3\2\2\2\20\32\34%+8BKS[crx|\u0083";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}