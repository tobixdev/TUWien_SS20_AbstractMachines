// Generated from language/src/main/java/com/oracle/truffle/sl/parser/Ringelnatter.g4 by ANTLR 4.7.1
package com.oracle.truffle.sl.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RingelnatterLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, LINE_COMMENT=31, 
		IDENTIFIER=32, NUMERIC_LITERAL=33, WS=34, NEWLINE=35;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "LINE_COMMENT", "LETTER", 
		"DIGIT", "IDENTIFIER", "NUMERIC_LITERAL", "WS", "NEWLINE", "SPACES"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'fn'", "'('", "','", "'):'", "'let'", "'='", "'ret'", "'if'", "':'", 
		"'.'", "'['", "']'", "'&&'", "'||'", "'=='", "'!='", "'>'", "'<'", "'>='", 
		"'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'is'", "')'", "'number'", 
		"'list'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "LINE_COMMENT", "IDENTIFIER", 
		"NUMERIC_LITERAL", "WS", "NEWLINE"
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


	  // A queue where extra tokens are pushed on (see the NEWLINE lexer rule).
	  private java.util.LinkedList<Token> tokens = new java.util.LinkedList<>();
	  // The stack that keeps track of the indentation level.
	  private java.util.Stack<Integer> indents = new java.util.Stack<>();
	  // The amount of opened braces, brackets and parenthesis.
	  private int opened = 0;
	  // The most recently produced token.
	  private Token lastToken = null;
	  @Override
	  public void emit(Token t) {
	    super.setToken(t);
	    tokens.offer(t);
	  }

	  @Override
	  public Token nextToken() {
	    // Check if the end-of-file is ahead and there are still some DEDENTS expected.
	    if (_input.LA(1) == EOF && !this.indents.isEmpty()) {
	      // Remove any trailing EOF tokens from our buffer.
	      for (int i = tokens.size() - 1; i >= 0; i--) {
	        if (tokens.get(i).getType() == EOF) {
	          tokens.remove(i);
	        }
	      }

	      // First emit an extra line break that serves as the end of the statement.
	      this.emit(commonToken(RingelnatterParser.NEWLINE, "\n"));

	      // Now emit as much DEDENT tokens as needed.
	      while (!indents.isEmpty()) {
	        this.emit(createDedent());
	        indents.pop();
	      }

	      // Put the EOF back on the token stream.
	      this.emit(commonToken(RingelnatterParser.EOF, "<EOF>"));
	    }

	    Token next = super.nextToken();

	    if (next.getChannel() == Token.DEFAULT_CHANNEL) {
	      // Keep track of the last token on the default channel.
	      this.lastToken = next;
	    }

	    return tokens.isEmpty() ? next : tokens.poll();
	  }

	  private Token createDedent() {
	    CommonToken dedent = commonToken(RingelnatterParser.DEDENT, "");
	    dedent.setLine(this.lastToken.getLine());
	    return dedent;
	  }

	  private CommonToken commonToken(int type, String text) {
	    int stop = this.getCharIndex() - 1;
	    int start = text.isEmpty() ? stop : stop - text.length() + 1;
	    return new CommonToken(this._tokenFactorySourcePair, type, DEFAULT_TOKEN_CHANNEL, start, stop);
	  }

	  static int getIndentationCount(String spaces) {
	    return spaces.length() / 2;
	  }

	  boolean atStartOfInput() {
	    return super.getCharPositionInLine() == 0 && super.getLine() == 1;
	  }


	public RingelnatterLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Ringelnatter.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 36:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			     String newLine = getText().replaceAll("[^\r\n\f]+", "");
			     String spaces = getText().replaceAll("[\r\n\f]+", "");

			     // Strip newlines inside open clauses except if we are near EOF. We keep NEWLINEs near EOF to
			     // satisfy the final newline needed by the single_put rule used by the REPL.
			     int next = _input.LA(1);
			     int nextnext = _input.LA(2);
			     if (opened > 0 || (nextnext != -1 && (next == '\r' || next == '\n' || next == '\f' || next == '#'))) {
			       // If we're inside a list or on a blank line, ignore all indents,
			       // dedents and line breaks.
			       skip();
			     }
			     else {
			       emit(commonToken(NEWLINE, newLine));
			       int indent = getIndentationCount(spaces);
			       int previous = indents.isEmpty() ? 0 : indents.peek();
			       if (indent == previous) {
			         // skip indents of the same size as the present indent-size
			         skip();
			       }
			       else if (indent > previous) {
			         indents.push(indent);
			         emit(commonToken(RingelnatterParser.INDENT, spaces));
			       }
			       else {
			         // Possibly emit more than 1 DEDENT token.
			         while(!indents.isEmpty() && indents.peek() > indent) {
			           this.emit(createDedent());
			           indents.pop();
			         }
			       }
			     }
			   
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 36:
			return NEWLINE_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean NEWLINE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return atStartOfInput();
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2%\u00d5\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\2\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n"+
		"\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34"+
		"\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3 \3 \7 \u00a4\n \f \16 \u00a7\13 \3 \3 \3!\5!\u00ac\n!\3\"\3\""+
		"\3#\3#\3#\7#\u00b3\n#\f#\16#\u00b6\13#\3$\6$\u00b9\n$\r$\16$\u00ba\3%"+
		"\3%\3%\3%\3&\3&\3&\5&\u00c4\n&\3&\3&\5&\u00c8\n&\3&\5&\u00cb\n&\5&\u00cd"+
		"\n&\3&\3&\3\'\6\'\u00d2\n\'\r\'\16\'\u00d3\2\2(\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\2C\2E\"G#I$K%M\2"+
		"\3\2\6\7\2\f\f\17\17GHQQ~~\5\2C\\aac|\3\2\62;\3\2\"\"\2\u00da\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3O\3"+
		"\2\2\2\5R\3\2\2\2\7T\3\2\2\2\tV\3\2\2\2\13Y\3\2\2\2\r]\3\2\2\2\17_\3\2"+
		"\2\2\21c\3\2\2\2\23f\3\2\2\2\25h\3\2\2\2\27j\3\2\2\2\31l\3\2\2\2\33n\3"+
		"\2\2\2\35q\3\2\2\2\37t\3\2\2\2!w\3\2\2\2#z\3\2\2\2%|\3\2\2\2\'~\3\2\2"+
		"\2)\u0081\3\2\2\2+\u0084\3\2\2\2-\u0086\3\2\2\2/\u0088\3\2\2\2\61\u008a"+
		"\3\2\2\2\63\u008c\3\2\2\2\65\u008e\3\2\2\2\67\u0090\3\2\2\29\u0093\3\2"+
		"\2\2;\u0095\3\2\2\2=\u009c\3\2\2\2?\u00a1\3\2\2\2A\u00ab\3\2\2\2C\u00ad"+
		"\3\2\2\2E\u00af\3\2\2\2G\u00b8\3\2\2\2I\u00bc\3\2\2\2K\u00cc\3\2\2\2M"+
		"\u00d1\3\2\2\2OP\7h\2\2PQ\7p\2\2Q\4\3\2\2\2RS\7*\2\2S\6\3\2\2\2TU\7.\2"+
		"\2U\b\3\2\2\2VW\7+\2\2WX\7<\2\2X\n\3\2\2\2YZ\7n\2\2Z[\7g\2\2[\\\7v\2\2"+
		"\\\f\3\2\2\2]^\7?\2\2^\16\3\2\2\2_`\7t\2\2`a\7g\2\2ab\7v\2\2b\20\3\2\2"+
		"\2cd\7k\2\2de\7h\2\2e\22\3\2\2\2fg\7<\2\2g\24\3\2\2\2hi\7\60\2\2i\26\3"+
		"\2\2\2jk\7]\2\2k\30\3\2\2\2lm\7_\2\2m\32\3\2\2\2no\7(\2\2op\7(\2\2p\34"+
		"\3\2\2\2qr\7~\2\2rs\7~\2\2s\36\3\2\2\2tu\7?\2\2uv\7?\2\2v \3\2\2\2wx\7"+
		"#\2\2xy\7?\2\2y\"\3\2\2\2z{\7@\2\2{$\3\2\2\2|}\7>\2\2}&\3\2\2\2~\177\7"+
		"@\2\2\177\u0080\7?\2\2\u0080(\3\2\2\2\u0081\u0082\7>\2\2\u0082\u0083\7"+
		"?\2\2\u0083*\3\2\2\2\u0084\u0085\7-\2\2\u0085,\3\2\2\2\u0086\u0087\7/"+
		"\2\2\u0087.\3\2\2\2\u0088\u0089\7,\2\2\u0089\60\3\2\2\2\u008a\u008b\7"+
		"\61\2\2\u008b\62\3\2\2\2\u008c\u008d\7\'\2\2\u008d\64\3\2\2\2\u008e\u008f"+
		"\7#\2\2\u008f\66\3\2\2\2\u0090\u0091\7k\2\2\u0091\u0092\7u\2\2\u00928"+
		"\3\2\2\2\u0093\u0094\7+\2\2\u0094:\3\2\2\2\u0095\u0096\7p\2\2\u0096\u0097"+
		"\7w\2\2\u0097\u0098\7o\2\2\u0098\u0099\7d\2\2\u0099\u009a\7g\2\2\u009a"+
		"\u009b\7t\2\2\u009b<\3\2\2\2\u009c\u009d\7n\2\2\u009d\u009e\7k\2\2\u009e"+
		"\u009f\7u\2\2\u009f\u00a0\7v\2\2\u00a0>\3\2\2\2\u00a1\u00a5\7%\2\2\u00a2"+
		"\u00a4\n\2\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2"+
		"\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8"+
		"\u00a9\b \2\2\u00a9@\3\2\2\2\u00aa\u00ac\t\3\2\2\u00ab\u00aa\3\2\2\2\u00ac"+
		"B\3\2\2\2\u00ad\u00ae\t\4\2\2\u00aeD\3\2\2\2\u00af\u00b4\5A!\2\u00b0\u00b3"+
		"\5A!\2\u00b1\u00b3\5C\"\2\u00b2\u00b0\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3"+
		"\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5F\3\2\2\2"+
		"\u00b6\u00b4\3\2\2\2\u00b7\u00b9\5C\"\2\u00b8\u00b7\3\2\2\2\u00b9\u00ba"+
		"\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bbH\3\2\2\2\u00bc"+
		"\u00bd\5M\'\2\u00bd\u00be\3\2\2\2\u00be\u00bf\b%\2\2\u00bfJ\3\2\2\2\u00c0"+
		"\u00c1\6&\2\2\u00c1\u00cd\5M\'\2\u00c2\u00c4\7\17\2\2\u00c3\u00c2\3\2"+
		"\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c8\7\f\2\2\u00c6"+
		"\u00c8\4\16\17\2\u00c7\u00c3\3\2\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00ca\3"+
		"\2\2\2\u00c9\u00cb\5M\'\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\u00cd\3\2\2\2\u00cc\u00c0\3\2\2\2\u00cc\u00c7\3\2\2\2\u00cd\u00ce\3\2"+
		"\2\2\u00ce\u00cf\b&\3\2\u00cfL\3\2\2\2\u00d0\u00d2\t\5\2\2\u00d1\u00d0"+
		"\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"N\3\2\2\2\r\2\u00a5\u00ab\u00b2\u00b4\u00ba\u00c3\u00c7\u00ca\u00cc\u00d3"+
		"\4\b\2\2\3&\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}