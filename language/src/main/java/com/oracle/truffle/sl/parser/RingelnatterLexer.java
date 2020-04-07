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
		T__17=18, T__18=19, T__19=20, T__20=21, LINE_COMMENT=22, IDENTIFIER=23, 
		NUMERIC_LITERAL=24, WS=25, NEWLINE=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "LINE_COMMENT", "LETTER", "DIGIT", 
		"TAB", "IDENTIFIER", "NUMERIC_LITERAL", "WS", "NEWLINE", "SPACES"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'fn'", "'('", "','", "'):'", "'let'", "'='", "'ret'", "'&&'", "'||'", 
		"'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", 
		"'%'", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "LINE_COMMENT", 
		"IDENTIFIER", "NUMERIC_LITERAL", "WS", "NEWLINE"
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
		case 28:
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
		case 28:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\34\u00ab\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2"+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\27\3\27\7\27x\n\27\f\27\16\27{\13\27\3\27"+
		"\3\27\3\30\5\30\u0080\n\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\7\33\u0089"+
		"\n\33\f\33\16\33\u008c\13\33\3\34\6\34\u008f\n\34\r\34\16\34\u0090\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\5\36\u009a\n\36\3\36\3\36\5\36\u009e\n"+
		"\36\3\36\5\36\u00a1\n\36\5\36\u00a3\n\36\3\36\3\36\3\37\6\37\u00a8\n\37"+
		"\r\37\16\37\u00a9\2\2 \3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\2\61\2\63\2\65"+
		"\31\67\329\33;\34=\2\3\2\6\7\2\f\f\17\17GHQQ~~\6\2&&C\\aac|\3\2\62;\4"+
		"\2\13\13\"\"\2\u00af\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\3?\3\2\2\2"+
		"\5B\3\2\2\2\7D\3\2\2\2\tF\3\2\2\2\13I\3\2\2\2\rM\3\2\2\2\17O\3\2\2\2\21"+
		"S\3\2\2\2\23V\3\2\2\2\25Y\3\2\2\2\27\\\3\2\2\2\31_\3\2\2\2\33a\3\2\2\2"+
		"\35c\3\2\2\2\37f\3\2\2\2!i\3\2\2\2#k\3\2\2\2%m\3\2\2\2\'o\3\2\2\2)q\3"+
		"\2\2\2+s\3\2\2\2-u\3\2\2\2/\177\3\2\2\2\61\u0081\3\2\2\2\63\u0083\3\2"+
		"\2\2\65\u0085\3\2\2\2\67\u008e\3\2\2\29\u0092\3\2\2\2;\u00a2\3\2\2\2="+
		"\u00a7\3\2\2\2?@\7h\2\2@A\7p\2\2A\4\3\2\2\2BC\7*\2\2C\6\3\2\2\2DE\7.\2"+
		"\2E\b\3\2\2\2FG\7+\2\2GH\7<\2\2H\n\3\2\2\2IJ\7n\2\2JK\7g\2\2KL\7v\2\2"+
		"L\f\3\2\2\2MN\7?\2\2N\16\3\2\2\2OP\7t\2\2PQ\7g\2\2QR\7v\2\2R\20\3\2\2"+
		"\2ST\7(\2\2TU\7(\2\2U\22\3\2\2\2VW\7~\2\2WX\7~\2\2X\24\3\2\2\2YZ\7?\2"+
		"\2Z[\7?\2\2[\26\3\2\2\2\\]\7#\2\2]^\7?\2\2^\30\3\2\2\2_`\7@\2\2`\32\3"+
		"\2\2\2ab\7>\2\2b\34\3\2\2\2cd\7@\2\2de\7?\2\2e\36\3\2\2\2fg\7>\2\2gh\7"+
		"?\2\2h \3\2\2\2ij\7-\2\2j\"\3\2\2\2kl\7/\2\2l$\3\2\2\2mn\7,\2\2n&\3\2"+
		"\2\2op\7\61\2\2p(\3\2\2\2qr\7\'\2\2r*\3\2\2\2st\7+\2\2t,\3\2\2\2uy\7%"+
		"\2\2vx\n\2\2\2wv\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z|\3\2\2\2{y\3\2"+
		"\2\2|}\b\27\2\2}.\3\2\2\2~\u0080\t\3\2\2\177~\3\2\2\2\u0080\60\3\2\2\2"+
		"\u0081\u0082\t\4\2\2\u0082\62\3\2\2\2\u0083\u0084\7\13\2\2\u0084\64\3"+
		"\2\2\2\u0085\u008a\5/\30\2\u0086\u0089\5/\30\2\u0087\u0089\5\61\31\2\u0088"+
		"\u0086\3\2\2\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2"+
		"\2\2\u008a\u008b\3\2\2\2\u008b\66\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u008f"+
		"\5\61\31\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u008e\3\2\2\2"+
		"\u0090\u0091\3\2\2\2\u00918\3\2\2\2\u0092\u0093\5=\37\2\u0093\u0094\3"+
		"\2\2\2\u0094\u0095\b\35\2\2\u0095:\3\2\2\2\u0096\u0097\6\36\2\2\u0097"+
		"\u00a3\5=\37\2\u0098\u009a\7\17\2\2\u0099\u0098\3\2\2\2\u0099\u009a\3"+
		"\2\2\2\u009a\u009b\3\2\2\2\u009b\u009e\7\f\2\2\u009c\u009e\4\16\17\2\u009d"+
		"\u0099\3\2\2\2\u009d\u009c\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u00a1\5="+
		"\37\2\u00a0\u009f\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2"+
		"\u0096\3\2\2\2\u00a2\u009d\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\b\36"+
		"\3\2\u00a5<\3\2\2\2\u00a6\u00a8\t\5\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9"+
		"\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa>\3\2\2\2\r\2y\177"+
		"\u0088\u008a\u0090\u0099\u009d\u00a0\u00a2\u00a9\4\b\2\2\3\36\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}