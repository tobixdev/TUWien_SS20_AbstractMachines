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
		T__9=10, T__10=11, T__11=12, LINE_COMMENT=13, IDENTIFIER=14, NUMERIC_LITERAL=15, 
		WS=16, NEWLINE=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "LINE_COMMENT", "LETTER", "DIGIT", "TAB", "IDENTIFIER", 
		"NUMERIC_LITERAL", "WS", "NEWLINE", "SPACES"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'fn '", "'('", "','", "'):'", "'let'", "'='", "'ret'", "'+'", "'-'", 
		"'*'", "'/'", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "LINE_COMMENT", "IDENTIFIER", "NUMERIC_LITERAL", "WS", "NEWLINE"
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
		case 19:
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
		case 19:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23\u0082\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\7\16O\n\16\f\16\16\16R\13\16"+
		"\3\16\3\16\3\17\5\17W\n\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\7\22`\n"+
		"\22\f\22\16\22c\13\22\3\23\6\23f\n\23\r\23\16\23g\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\5\25q\n\25\3\25\3\25\5\25u\n\25\3\25\5\25x\n\25\5\25z"+
		"\n\25\3\25\3\25\3\26\6\26\177\n\26\r\26\16\26\u0080\2\2\27\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\2\37\2!\2#\20%"+
		"\21\'\22)\23+\2\3\2\6\7\2\f\f\17\17GHQQ~~\6\2&&C\\aac|\3\2\62;\4\2\13"+
		"\13\"\"\2\u0086\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\3-\3\2\2\2\5\61\3\2\2\2\7\63\3\2\2\2\t\65\3\2\2\2\138"+
		"\3\2\2\2\r<\3\2\2\2\17>\3\2\2\2\21B\3\2\2\2\23D\3\2\2\2\25F\3\2\2\2\27"+
		"H\3\2\2\2\31J\3\2\2\2\33L\3\2\2\2\35V\3\2\2\2\37X\3\2\2\2!Z\3\2\2\2#\\"+
		"\3\2\2\2%e\3\2\2\2\'i\3\2\2\2)y\3\2\2\2+~\3\2\2\2-.\7h\2\2./\7p\2\2/\60"+
		"\7\"\2\2\60\4\3\2\2\2\61\62\7*\2\2\62\6\3\2\2\2\63\64\7.\2\2\64\b\3\2"+
		"\2\2\65\66\7+\2\2\66\67\7<\2\2\67\n\3\2\2\289\7n\2\29:\7g\2\2:;\7v\2\2"+
		";\f\3\2\2\2<=\7?\2\2=\16\3\2\2\2>?\7t\2\2?@\7g\2\2@A\7v\2\2A\20\3\2\2"+
		"\2BC\7-\2\2C\22\3\2\2\2DE\7/\2\2E\24\3\2\2\2FG\7,\2\2G\26\3\2\2\2HI\7"+
		"\61\2\2I\30\3\2\2\2JK\7+\2\2K\32\3\2\2\2LP\7%\2\2MO\n\2\2\2NM\3\2\2\2"+
		"OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QS\3\2\2\2RP\3\2\2\2ST\b\16\2\2T\34\3\2"+
		"\2\2UW\t\3\2\2VU\3\2\2\2W\36\3\2\2\2XY\t\4\2\2Y \3\2\2\2Z[\7\13\2\2[\""+
		"\3\2\2\2\\a\5\35\17\2]`\5\35\17\2^`\5\37\20\2_]\3\2\2\2_^\3\2\2\2`c\3"+
		"\2\2\2a_\3\2\2\2ab\3\2\2\2b$\3\2\2\2ca\3\2\2\2df\5\37\20\2ed\3\2\2\2f"+
		"g\3\2\2\2ge\3\2\2\2gh\3\2\2\2h&\3\2\2\2ij\5+\26\2jk\3\2\2\2kl\b\24\2\2"+
		"l(\3\2\2\2mn\6\25\2\2nz\5+\26\2oq\7\17\2\2po\3\2\2\2pq\3\2\2\2qr\3\2\2"+
		"\2ru\7\f\2\2su\4\16\17\2tp\3\2\2\2ts\3\2\2\2uw\3\2\2\2vx\5+\26\2wv\3\2"+
		"\2\2wx\3\2\2\2xz\3\2\2\2ym\3\2\2\2yt\3\2\2\2z{\3\2\2\2{|\b\25\3\2|*\3"+
		"\2\2\2}\177\t\5\2\2~}\3\2\2\2\177\u0080\3\2\2\2\u0080~\3\2\2\2\u0080\u0081"+
		"\3\2\2\2\u0081,\3\2\2\2\r\2PV_agptwy\u0080\4\b\2\2\3\25\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}