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
		T__24=25, LINE_COMMENT=26, IDENTIFIER=27, NUMERIC_LITERAL=28, WS=29, NEWLINE=30;
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
		"LINE_COMMENT", "LETTER", "DIGIT", "TAB", "IDENTIFIER", "NUMERIC_LITERAL", 
		"WS", "NEWLINE", "SPACES"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'fn'", "'('", "','", "'):'", "'let'", "'='", "'ret'", "'&&'", "'||'", 
		"'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", 
		"'%'", "'!'", "'is'", "')'", "'number'", "'list'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "LINE_COMMENT", "IDENTIFIER", "NUMERIC_LITERAL", "WS", "NEWLINE"
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


	  private java.util.LinkedList<Token> tokens = new java.util.LinkedList<>();
	  private java.util.Stack<Integer> indents = new java.util.Stack<>();
	  private int opened = 0;
	  private Token lastToken = null;
	  @Override
	  public void emit(Token t) {
	    super.setToken(t);
	    tokens.offer(t);
	  }

	  @Override
	  public Token nextToken() {
	    if (_input.LA(1) == EOF && !this.indents.isEmpty()) {
	      for (int i = tokens.size() - 1; i >= 0; i--) {
	        if (tokens.get(i).getType() == EOF) {
	          tokens.remove(i);
	        }
	      }

	      this.emit(commonToken(RingelnatterLexer.NEWLINE, "\n"));

	      while (!indents.isEmpty()) {
	        this.emit(createDedent());
	        indents.pop();
	      }

	      this.emit(commonToken(RingelnatterLexer.EOF, "<EOF>"));
	    }

	    Token next = super.nextToken();

	    if (next.getChannel() == Token.DEFAULT_CHANNEL) {
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
	    int count = 0;
	    for (char ch : spaces.toCharArray()) {
	      switch (ch) {
	        case '\t':
	          count += 8 - (count % 8);
	          break;
	        default:
	          // A normal space char.
	          count++;
	      }
	    }

	    return count;
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
		case 32:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			     String newLine = getText().replaceAll("[^\r\n\f]+", "");
			     String spaces = getText().replaceAll("[\r\n\f]+", "");

			     int next = _input.LA(1);
			     int nextnext = _input.LA(2);
			     if (opened > 0 || (nextnext != -1 && (next == '\r' || next == '\n' || next == '\f' || next == '#'))) {
			       skip();
			     }
			     else {
			       emit(commonToken(NEWLINE, newLine));
			       int indent = getIndentationCount(spaces);
			       int previous = indents.isEmpty() ? 0 : indents.peek();
			       if (indent == previous) {
			         skip();
			       }
			       else if (indent > previous) {
			         indents.push(indent);
			         emit(commonToken(RingelnatterParser.INDENT, spaces));
			       }
			       else {
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
		case 32:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2 \u00c4\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3"+
		"\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3"+
		"\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3"+
		"\33\7\33\u0091\n\33\f\33\16\33\u0094\13\33\3\33\3\33\3\34\5\34\u0099\n"+
		"\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37\7\37\u00a2\n\37\f\37\16\37\u00a5"+
		"\13\37\3 \6 \u00a8\n \r \16 \u00a9\3!\3!\3!\3!\3\"\3\"\3\"\5\"\u00b3\n"+
		"\"\3\"\3\"\5\"\u00b7\n\"\3\"\5\"\u00ba\n\"\5\"\u00bc\n\"\3\"\3\"\3#\6"+
		"#\u00c1\n#\r#\16#\u00c2\2\2$\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\29\2;\2=\35?\36A\37C E\2\3\2\6\7\2\f\f\17\17GHQQ~~"+
		"\6\2&&C\\aac|\3\2\62;\4\2\13\13\"\"\2\u00c8\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\3G\3\2\2\2"+
		"\5J\3\2\2\2\7L\3\2\2\2\tN\3\2\2\2\13Q\3\2\2\2\rU\3\2\2\2\17W\3\2\2\2\21"+
		"[\3\2\2\2\23^\3\2\2\2\25a\3\2\2\2\27d\3\2\2\2\31g\3\2\2\2\33i\3\2\2\2"+
		"\35k\3\2\2\2\37n\3\2\2\2!q\3\2\2\2#s\3\2\2\2%u\3\2\2\2\'w\3\2\2\2)y\3"+
		"\2\2\2+{\3\2\2\2-}\3\2\2\2/\u0080\3\2\2\2\61\u0082\3\2\2\2\63\u0089\3"+
		"\2\2\2\65\u008e\3\2\2\2\67\u0098\3\2\2\29\u009a\3\2\2\2;\u009c\3\2\2\2"+
		"=\u009e\3\2\2\2?\u00a7\3\2\2\2A\u00ab\3\2\2\2C\u00bb\3\2\2\2E\u00c0\3"+
		"\2\2\2GH\7h\2\2HI\7p\2\2I\4\3\2\2\2JK\7*\2\2K\6\3\2\2\2LM\7.\2\2M\b\3"+
		"\2\2\2NO\7+\2\2OP\7<\2\2P\n\3\2\2\2QR\7n\2\2RS\7g\2\2ST\7v\2\2T\f\3\2"+
		"\2\2UV\7?\2\2V\16\3\2\2\2WX\7t\2\2XY\7g\2\2YZ\7v\2\2Z\20\3\2\2\2[\\\7"+
		"(\2\2\\]\7(\2\2]\22\3\2\2\2^_\7~\2\2_`\7~\2\2`\24\3\2\2\2ab\7?\2\2bc\7"+
		"?\2\2c\26\3\2\2\2de\7#\2\2ef\7?\2\2f\30\3\2\2\2gh\7@\2\2h\32\3\2\2\2i"+
		"j\7>\2\2j\34\3\2\2\2kl\7@\2\2lm\7?\2\2m\36\3\2\2\2no\7>\2\2op\7?\2\2p"+
		" \3\2\2\2qr\7-\2\2r\"\3\2\2\2st\7/\2\2t$\3\2\2\2uv\7,\2\2v&\3\2\2\2wx"+
		"\7\61\2\2x(\3\2\2\2yz\7\'\2\2z*\3\2\2\2{|\7#\2\2|,\3\2\2\2}~\7k\2\2~\177"+
		"\7u\2\2\177.\3\2\2\2\u0080\u0081\7+\2\2\u0081\60\3\2\2\2\u0082\u0083\7"+
		"p\2\2\u0083\u0084\7w\2\2\u0084\u0085\7o\2\2\u0085\u0086\7d\2\2\u0086\u0087"+
		"\7g\2\2\u0087\u0088\7t\2\2\u0088\62\3\2\2\2\u0089\u008a\7n\2\2\u008a\u008b"+
		"\7k\2\2\u008b\u008c\7u\2\2\u008c\u008d\7v\2\2\u008d\64\3\2\2\2\u008e\u0092"+
		"\7%\2\2\u008f\u0091\n\2\2\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\3\2\2\2\u0094\u0092\3\2"+
		"\2\2\u0095\u0096\b\33\2\2\u0096\66\3\2\2\2\u0097\u0099\t\3\2\2\u0098\u0097"+
		"\3\2\2\2\u00998\3\2\2\2\u009a\u009b\t\4\2\2\u009b:\3\2\2\2\u009c\u009d"+
		"\7\13\2\2\u009d<\3\2\2\2\u009e\u00a3\5\67\34\2\u009f\u00a2\5\67\34\2\u00a0"+
		"\u00a2\59\35\2\u00a1\u009f\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a5\3\2"+
		"\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4>\3\2\2\2\u00a5\u00a3"+
		"\3\2\2\2\u00a6\u00a8\59\35\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa@\3\2\2\2\u00ab\u00ac\5E#\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\u00ae\b!\2\2\u00aeB\3\2\2\2\u00af\u00b0\6\"\2\2\u00b0"+
		"\u00bc\5E#\2\u00b1\u00b3\7\17\2\2\u00b2\u00b1\3\2\2\2\u00b2\u00b3\3\2"+
		"\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b7\7\f\2\2\u00b5\u00b7\4\16\17\2\u00b6"+
		"\u00b2\3\2\2\2\u00b6\u00b5\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00ba\5E"+
		"#\2\u00b9\u00b8\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bc\3\2\2\2\u00bb"+
		"\u00af\3\2\2\2\u00bb\u00b6\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\b\""+
		"\3\2\u00beD\3\2\2\2\u00bf\u00c1\t\5\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c2"+
		"\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3F\3\2\2\2\r\2\u0092"+
		"\u0098\u00a1\u00a3\u00a9\u00b2\u00b6\u00b9\u00bb\u00c2\4\b\2\2\3\"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}