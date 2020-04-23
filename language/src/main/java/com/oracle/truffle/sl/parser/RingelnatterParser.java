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
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, LINE_COMMENT=37, IDENTIFIER=38, 
		NUMERIC_LITERAL=39, WS=40, NEWLINE=41, INDENT=42, DEDENT=43;
	public static final int
		RULE_ringelnatter = 0, RULE_function = 1, RULE_suite = 2, RULE_stmnt = 3, 
		RULE_multilineexpression = 4, RULE_expression = 5, RULE_logical_term = 6, 
		RULE_logical_factor = 7, RULE_arithmetic = 8, RULE_term = 9, RULE_factor = 10, 
		RULE_listfactor = 11, RULE_matchexpr = 12, RULE_listmatchexpr = 13, RULE_listmatchelementexpr = 14, 
		RULE_evalexpression = 15, RULE_arm = 16, RULE_typename = 17;
	public static final String[] ruleNames = {
		"ringelnatter", "function", "suite", "stmnt", "multilineexpression", "expression", 
		"logical_term", "logical_factor", "arithmetic", "term", "factor", "listfactor", 
		"matchexpr", "listmatchexpr", "listmatchelementexpr", "evalexpression", 
		"arm", "typename"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'fn'", "'('", "','", "'):'", "'='", "'let'", "'ret'", "'if'", "':'", 
		"'elif'", "'else'", "'while'", "'.'", "'&&'", "'||'", "'=='", "'!='", 
		"'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", 
		"'is'", "'matches'", "')'", "'['", "']'", "'eval'", "'_'", "'number'", 
		"'list'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "LINE_COMMENT", "IDENTIFIER", "NUMERIC_LITERAL", "WS", "NEWLINE", 
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
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==NEWLINE) {
				{
				setState(38);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(36);
					function();
					}
					break;
				case NEWLINE:
					{
					setState(37);
					match(NEWLINE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
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
			setState(45);
			match(T__0);
			setState(46);
			match(IDENTIFIER);
			setState(47);
			match(T__1);
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(48);
				match(IDENTIFIER);
				}
			}

			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(51);
				match(T__2);
				setState(52);
				match(IDENTIFIER);
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58);
			match(T__3);
			setState(59);
			match(NEWLINE);
			setState(60);
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
			setState(62);
			match(INDENT);
			setState(64); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(63);
				stmnt();
				}
				}
				setState(66); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__11) | (1L << IDENTIFIER))) != 0) );
			setState(68);
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
		public MultilineexpressionContext multilineexpression() {
			return getRuleContext(MultilineexpressionContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(RingelnatterParser.IDENTIFIER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(RingelnatterParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RingelnatterParser.NEWLINE, i);
		}
		public List<SuiteContext> suite() {
			return getRuleContexts(SuiteContext.class);
		}
		public SuiteContext suite(int i) {
			return getRuleContext(SuiteContext.class,i);
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
		int _la;
		try {
			setState(107);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				((StmntContext)_localctx).var = match(IDENTIFIER);
				setState(71);
				match(T__4);
				setState(72);
				multilineexpression();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				match(T__5);
				setState(74);
				((StmntContext)_localctx).var = match(IDENTIFIER);
				setState(75);
				match(T__4);
				setState(76);
				multilineexpression();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(77);
				match(T__6);
				setState(78);
				multilineexpression();
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
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(84);
					match(T__9);
					setState(85);
					expression();
					setState(86);
					match(T__8);
					setState(87);
					match(NEWLINE);
					setState(88);
					suite();
					}
					}
					setState(94);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(95);
					match(T__10);
					setState(96);
					match(T__8);
					setState(97);
					match(NEWLINE);
					setState(98);
					suite();
					}
				}

				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 5);
				{
				setState(101);
				match(T__11);
				setState(102);
				expression();
				setState(103);
				match(T__8);
				setState(104);
				match(NEWLINE);
				setState(105);
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

	public static class MultilineexpressionContext extends ParserRuleContext {
		public EvalexpressionContext evalexpression() {
			return getRuleContext(EvalexpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(RingelnatterParser.NEWLINE, 0); }
		public MultilineexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multilineexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).enterMultilineexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).exitMultilineexpression(this);
		}
	}

	public final MultilineexpressionContext multilineexpression() throws RecognitionException {
		MultilineexpressionContext _localctx = new MultilineexpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_multilineexpression);
		try {
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				evalexpression();
				}
				break;
			case T__1:
			case T__26:
			case T__30:
			case IDENTIFIER:
			case NUMERIC_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(110);
				expression();
				setState(111);
				match(NEWLINE);
				}
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
		enterRule(_localctx, 10, RULE_expression);
		int _la;
		try {
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				logical_term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				factor(0);
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(117);
					match(T__12);
					setState(118);
					factor(0);
					}
					}
					setState(121); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__12 );
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
		enterRule(_localctx, 12, RULE_logical_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			logical_factor();
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13 || _la==T__14) {
				{
				{
				setState(126);
				((Logical_termContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__13 || _la==T__14) ) {
					((Logical_termContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(127);
				logical_factor();
				}
				}
				setState(132);
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
		enterRule(_localctx, 14, RULE_logical_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			arithmetic();
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20))) != 0)) {
				{
				{
				setState(134);
				((Logical_factorContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20))) != 0)) ) {
					((Logical_factorContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(135);
				arithmetic();
				}
				}
				setState(140);
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
		enterRule(_localctx, 16, RULE_arithmetic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			term();
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21 || _la==T__22) {
				{
				{
				setState(142);
				((ArithmeticContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__21 || _la==T__22) ) {
					((ArithmeticContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(143);
				term();
				}
				}
				setState(148);
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
		enterRule(_localctx, 18, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			factor(0);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) {
				{
				{
				setState(150);
				((TermContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) ) {
					((TermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(151);
				factor(0);
				}
				}
				setState(156);
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_factor, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(158);
				((FactorContext)_localctx).op = match(T__26);
				setState(159);
				factor(8);
				}
				break;
			case 2:
				{
				setState(160);
				match(NUMERIC_LITERAL);
				}
				break;
			case 3:
				{
				setState(161);
				listfactor();
				}
				break;
			case 4:
				{
				setState(162);
				((FactorContext)_localctx).var = match(IDENTIFIER);
				}
				break;
			case 5:
				{
				setState(163);
				match(T__1);
				setState(164);
				expression();
				setState(165);
				match(T__29);
				}
				break;
			case 6:
				{
				setState(167);
				((FactorContext)_localctx).target = match(IDENTIFIER);
				setState(168);
				match(T__1);
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__26) | (1L << T__30) | (1L << IDENTIFIER) | (1L << NUMERIC_LITERAL))) != 0)) {
					{
					setState(169);
					expression();
					}
				}

				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(172);
					match(T__2);
					setState(173);
					expression();
					}
					}
					setState(178);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(179);
				match(T__29);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(190);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(188);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new FactorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_factor);
						setState(182);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(183);
						((FactorContext)_localctx).op = match(T__27);
						setState(184);
						typename();
						}
						break;
					case 2:
						{
						_localctx = new FactorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_factor);
						setState(185);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(186);
						((FactorContext)_localctx).op = match(T__28);
						setState(187);
						matchexpr();
						}
						break;
					}
					} 
				}
				setState(192);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
		enterRule(_localctx, 22, RULE_listfactor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(T__30);
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__26) | (1L << T__30) | (1L << IDENTIFIER) | (1L << NUMERIC_LITERAL))) != 0)) {
				{
				setState(194);
				expression();
				}
			}

			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(197);
				match(T__2);
				setState(198);
				expression();
				}
				}
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(204);
			match(T__31);
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
		public TerminalNode IDENTIFIER() { return getToken(RingelnatterParser.IDENTIFIER, 0); }
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
		enterRule(_localctx, 24, RULE_matchexpr);
		try {
			setState(209);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMERIC_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(206);
				match(NUMERIC_LITERAL);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(207);
				match(IDENTIFIER);
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 3);
				{
				setState(208);
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
		enterRule(_localctx, 26, RULE_listmatchexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(T__30);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << IDENTIFIER) | (1L << NUMERIC_LITERAL))) != 0)) {
				{
				setState(212);
				listmatchelementexpr();
				}
			}

			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(215);
				match(T__12);
				setState(216);
				listmatchelementexpr();
				}
				}
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(222);
			match(T__31);
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
		enterRule(_localctx, 28, RULE_listmatchelementexpr);
		try {
			setState(226);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(224);
				matchexpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
				match(IDENTIFIER);
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

	public static class EvalexpressionContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(RingelnatterParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RingelnatterParser.NEWLINE, i);
		}
		public TerminalNode INDENT() { return getToken(RingelnatterParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(RingelnatterParser.DEDENT, 0); }
		public List<ArmContext> arm() {
			return getRuleContexts(ArmContext.class);
		}
		public ArmContext arm(int i) {
			return getRuleContext(ArmContext.class,i);
		}
		public EvalexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_evalexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).enterEvalexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).exitEvalexpression(this);
		}
	}

	public final EvalexpressionContext evalexpression() throws RecognitionException {
		EvalexpressionContext _localctx = new EvalexpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_evalexpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(T__32);
			setState(229);
			match(T__8);
			setState(230);
			match(NEWLINE);
			setState(231);
			match(INDENT);
			setState(235); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(232);
				arm();
				setState(233);
				match(NEWLINE);
				}
				}
				setState(237); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__26) | (1L << T__30) | (1L << T__33) | (1L << IDENTIFIER) | (1L << NUMERIC_LITERAL))) != 0) );
			setState(239);
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

	public static class ArmContext extends ParserRuleContext {
		public ExpressionContext guard;
		public ExpressionContext value;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).enterArm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RingelnatterListener ) ((RingelnatterListener)listener).exitArm(this);
		}
	}

	public final ArmContext arm() throws RecognitionException {
		ArmContext _localctx = new ArmContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_arm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__26:
			case T__30:
			case IDENTIFIER:
			case NUMERIC_LITERAL:
				{
				setState(241);
				((ArmContext)_localctx).guard = expression();
				}
				break;
			case T__33:
				{
				setState(242);
				match(T__33);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(245);
			match(T__8);
			setState(246);
			((ArmContext)_localctx).value = expression();
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
		enterRule(_localctx, 34, RULE_typename);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			_la = _input.LA(1);
			if ( !(_la==T__34 || _la==T__35) ) {
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
		case 10:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u00fd\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\7\2)\n\2\f\2\16\2,\13\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3"+
		"\64\n\3\3\3\3\3\7\38\n\3\f\3\16\3;\13\3\3\3\3\3\3\3\3\3\3\4\3\4\6\4C\n"+
		"\4\r\4\16\4D\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5]\n\5\f\5\16\5`\13\5\3\5\3\5\3\5\3\5"+
		"\5\5f\n\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5n\n\5\3\6\3\6\3\6\3\6\5\6t\n\6\3"+
		"\7\3\7\3\7\3\7\6\7z\n\7\r\7\16\7{\5\7~\n\7\3\b\3\b\3\b\7\b\u0083\n\b\f"+
		"\b\16\b\u0086\13\b\3\t\3\t\3\t\7\t\u008b\n\t\f\t\16\t\u008e\13\t\3\n\3"+
		"\n\3\n\7\n\u0093\n\n\f\n\16\n\u0096\13\n\3\13\3\13\3\13\7\13\u009b\n\13"+
		"\f\13\16\13\u009e\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\5\f\u00ad\n\f\3\f\3\f\7\f\u00b1\n\f\f\f\16\f\u00b4\13\f\3\f\5\f"+
		"\u00b7\n\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00bf\n\f\f\f\16\f\u00c2\13\f\3"+
		"\r\3\r\5\r\u00c6\n\r\3\r\3\r\7\r\u00ca\n\r\f\r\16\r\u00cd\13\r\3\r\3\r"+
		"\3\16\3\16\3\16\5\16\u00d4\n\16\3\17\3\17\5\17\u00d8\n\17\3\17\3\17\7"+
		"\17\u00dc\n\17\f\17\16\17\u00df\13\17\3\17\3\17\3\20\3\20\5\20\u00e5\n"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\6\21\u00ee\n\21\r\21\16\21\u00ef"+
		"\3\21\3\21\3\22\3\22\5\22\u00f6\n\22\3\22\3\22\3\22\3\23\3\23\3\23\2\3"+
		"\26\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\7\3\2\20\21\3\2\22"+
		"\27\3\2\30\31\3\2\32\34\3\2%&\2\u010e\2*\3\2\2\2\4/\3\2\2\2\6@\3\2\2\2"+
		"\bm\3\2\2\2\ns\3\2\2\2\f}\3\2\2\2\16\177\3\2\2\2\20\u0087\3\2\2\2\22\u008f"+
		"\3\2\2\2\24\u0097\3\2\2\2\26\u00b6\3\2\2\2\30\u00c3\3\2\2\2\32\u00d3\3"+
		"\2\2\2\34\u00d5\3\2\2\2\36\u00e4\3\2\2\2 \u00e6\3\2\2\2\"\u00f5\3\2\2"+
		"\2$\u00fa\3\2\2\2&)\5\4\3\2\')\7+\2\2(&\3\2\2\2(\'\3\2\2\2),\3\2\2\2*"+
		"(\3\2\2\2*+\3\2\2\2+-\3\2\2\2,*\3\2\2\2-.\7\2\2\3.\3\3\2\2\2/\60\7\3\2"+
		"\2\60\61\7(\2\2\61\63\7\4\2\2\62\64\7(\2\2\63\62\3\2\2\2\63\64\3\2\2\2"+
		"\649\3\2\2\2\65\66\7\5\2\2\668\7(\2\2\67\65\3\2\2\28;\3\2\2\29\67\3\2"+
		"\2\29:\3\2\2\2:<\3\2\2\2;9\3\2\2\2<=\7\6\2\2=>\7+\2\2>?\5\6\4\2?\5\3\2"+
		"\2\2@B\7,\2\2AC\5\b\5\2BA\3\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2EF\3\2"+
		"\2\2FG\7-\2\2G\7\3\2\2\2HI\7(\2\2IJ\7\7\2\2Jn\5\n\6\2KL\7\b\2\2LM\7(\2"+
		"\2MN\7\7\2\2Nn\5\n\6\2OP\7\t\2\2Pn\5\n\6\2QR\7\n\2\2RS\5\f\7\2ST\7\13"+
		"\2\2TU\7+\2\2U^\5\6\4\2VW\7\f\2\2WX\5\f\7\2XY\7\13\2\2YZ\7+\2\2Z[\5\6"+
		"\4\2[]\3\2\2\2\\V\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_e\3\2\2\2`^\3"+
		"\2\2\2ab\7\r\2\2bc\7\13\2\2cd\7+\2\2df\5\6\4\2ea\3\2\2\2ef\3\2\2\2fn\3"+
		"\2\2\2gh\7\16\2\2hi\5\f\7\2ij\7\13\2\2jk\7+\2\2kl\5\6\4\2ln\3\2\2\2mH"+
		"\3\2\2\2mK\3\2\2\2mO\3\2\2\2mQ\3\2\2\2mg\3\2\2\2n\t\3\2\2\2ot\5 \21\2"+
		"pq\5\f\7\2qr\7+\2\2rt\3\2\2\2so\3\2\2\2sp\3\2\2\2t\13\3\2\2\2u~\5\16\b"+
		"\2vy\5\26\f\2wx\7\17\2\2xz\5\26\f\2yw\3\2\2\2z{\3\2\2\2{y\3\2\2\2{|\3"+
		"\2\2\2|~\3\2\2\2}u\3\2\2\2}v\3\2\2\2~\r\3\2\2\2\177\u0084\5\20\t\2\u0080"+
		"\u0081\t\2\2\2\u0081\u0083\5\20\t\2\u0082\u0080\3\2\2\2\u0083\u0086\3"+
		"\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\17\3\2\2\2\u0086"+
		"\u0084\3\2\2\2\u0087\u008c\5\22\n\2\u0088\u0089\t\3\2\2\u0089\u008b\5"+
		"\22\n\2\u008a\u0088\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\21\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0094\5\24\13"+
		"\2\u0090\u0091\t\4\2\2\u0091\u0093\5\24\13\2\u0092\u0090\3\2\2\2\u0093"+
		"\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\23\3\2\2"+
		"\2\u0096\u0094\3\2\2\2\u0097\u009c\5\26\f\2\u0098\u0099\t\5\2\2\u0099"+
		"\u009b\5\26\f\2\u009a\u0098\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3"+
		"\2\2\2\u009c\u009d\3\2\2\2\u009d\25\3\2\2\2\u009e\u009c\3\2\2\2\u009f"+
		"\u00a0\b\f\1\2\u00a0\u00a1\7\35\2\2\u00a1\u00b7\5\26\f\n\u00a2\u00b7\7"+
		")\2\2\u00a3\u00b7\5\30\r\2\u00a4\u00b7\7(\2\2\u00a5\u00a6\7\4\2\2\u00a6"+
		"\u00a7\5\f\7\2\u00a7\u00a8\7 \2\2\u00a8\u00b7\3\2\2\2\u00a9\u00aa\7(\2"+
		"\2\u00aa\u00ac\7\4\2\2\u00ab\u00ad\5\f\7\2\u00ac\u00ab\3\2\2\2\u00ac\u00ad"+
		"\3\2\2\2\u00ad\u00b2\3\2\2\2\u00ae\u00af\7\5\2\2\u00af\u00b1\5\f\7\2\u00b0"+
		"\u00ae\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2"+
		"\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b7\7 \2\2\u00b6"+
		"\u009f\3\2\2\2\u00b6\u00a2\3\2\2\2\u00b6\u00a3\3\2\2\2\u00b6\u00a4\3\2"+
		"\2\2\u00b6\u00a5\3\2\2\2\u00b6\u00a9\3\2\2\2\u00b7\u00c0\3\2\2\2\u00b8"+
		"\u00b9\f\t\2\2\u00b9\u00ba\7\36\2\2\u00ba\u00bf\5$\23\2\u00bb\u00bc\f"+
		"\b\2\2\u00bc\u00bd\7\37\2\2\u00bd\u00bf\5\32\16\2\u00be\u00b8\3\2\2\2"+
		"\u00be\u00bb\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1"+
		"\3\2\2\2\u00c1\27\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c5\7!\2\2\u00c4"+
		"\u00c6\5\f\7\2\u00c5\u00c4\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00cb\3\2"+
		"\2\2\u00c7\u00c8\7\5\2\2\u00c8\u00ca\5\f\7\2\u00c9\u00c7\3\2\2\2\u00ca"+
		"\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ce\3\2"+
		"\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00cf\7\"\2\2\u00cf\31\3\2\2\2\u00d0\u00d4"+
		"\7)\2\2\u00d1\u00d4\7(\2\2\u00d2\u00d4\5\34\17\2\u00d3\u00d0\3\2\2\2\u00d3"+
		"\u00d1\3\2\2\2\u00d3\u00d2\3\2\2\2\u00d4\33\3\2\2\2\u00d5\u00d7\7!\2\2"+
		"\u00d6\u00d8\5\36\20\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00dd"+
		"\3\2\2\2\u00d9\u00da\7\17\2\2\u00da\u00dc\5\36\20\2\u00db\u00d9\3\2\2"+
		"\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e0"+
		"\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e1\7\"\2\2\u00e1\35\3\2\2\2\u00e2"+
		"\u00e5\5\32\16\2\u00e3\u00e5\7(\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3"+
		"\2\2\2\u00e5\37\3\2\2\2\u00e6\u00e7\7#\2\2\u00e7\u00e8\7\13\2\2\u00e8"+
		"\u00e9\7+\2\2\u00e9\u00ed\7,\2\2\u00ea\u00eb\5\"\22\2\u00eb\u00ec\7+\2"+
		"\2\u00ec\u00ee\3\2\2\2\u00ed\u00ea\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00ed"+
		"\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\7-\2\2\u00f2"+
		"!\3\2\2\2\u00f3\u00f6\5\f\7\2\u00f4\u00f6\7$\2\2\u00f5\u00f3\3\2\2\2\u00f5"+
		"\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\7\13\2\2\u00f8\u00f9\5"+
		"\f\7\2\u00f9#\3\2\2\2\u00fa\u00fb\t\6\2\2\u00fb%\3\2\2\2\36(*\639D^em"+
		"s{}\u0084\u008c\u0094\u009c\u00ac\u00b2\u00b6\u00be\u00c0\u00c5\u00cb"+
		"\u00d3\u00d7\u00dd\u00e4\u00ef\u00f5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}