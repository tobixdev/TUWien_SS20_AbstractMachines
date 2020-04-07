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
		T__9=10, T__10=11, T__11=12, T__12=13, LINE_COMMENT=14, IDENTIFIER=15, 
		NUMERIC_LITERAL=16, WS=17, NEWLINE=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "LINE_COMMENT", "LETTER", "DIGIT", 
		"TAB", "IDENTIFIER", "NUMERIC_LITERAL", "WS", "NEWLINE", "SPACES"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'fn'", "'('", "','", "'):'", "'let'", "'='", "'ret'", "'+'", "'-'", 
		"'*'", "'/'", "'%'", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
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
		case 20:
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
		case 20:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u0085\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\7\17R\n\17"+
		"\f\17\16\17U\13\17\3\17\3\17\3\20\5\20Z\n\20\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\23\7\23c\n\23\f\23\16\23f\13\23\3\24\6\24i\n\24\r\24\16\24j\3"+
		"\25\3\25\3\25\3\25\3\26\3\26\3\26\5\26t\n\26\3\26\3\26\5\26x\n\26\3\26"+
		"\5\26{\n\26\5\26}\n\26\3\26\3\26\3\27\6\27\u0082\n\27\r\27\16\27\u0083"+
		"\2\2\30\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\2!\2#\2%\21\'\22)\23+\24-\2\3\2\6\7\2\f\f\17\17GHQQ~~\6\2&&"+
		"C\\aac|\3\2\62;\4\2\13\13\"\"\2\u0089\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3/\3\2\2\2\5\62\3"+
		"\2\2\2\7\64\3\2\2\2\t\66\3\2\2\2\139\3\2\2\2\r=\3\2\2\2\17?\3\2\2\2\21"+
		"C\3\2\2\2\23E\3\2\2\2\25G\3\2\2\2\27I\3\2\2\2\31K\3\2\2\2\33M\3\2\2\2"+
		"\35O\3\2\2\2\37Y\3\2\2\2![\3\2\2\2#]\3\2\2\2%_\3\2\2\2\'h\3\2\2\2)l\3"+
		"\2\2\2+|\3\2\2\2-\u0081\3\2\2\2/\60\7h\2\2\60\61\7p\2\2\61\4\3\2\2\2\62"+
		"\63\7*\2\2\63\6\3\2\2\2\64\65\7.\2\2\65\b\3\2\2\2\66\67\7+\2\2\678\7<"+
		"\2\28\n\3\2\2\29:\7n\2\2:;\7g\2\2;<\7v\2\2<\f\3\2\2\2=>\7?\2\2>\16\3\2"+
		"\2\2?@\7t\2\2@A\7g\2\2AB\7v\2\2B\20\3\2\2\2CD\7-\2\2D\22\3\2\2\2EF\7/"+
		"\2\2F\24\3\2\2\2GH\7,\2\2H\26\3\2\2\2IJ\7\61\2\2J\30\3\2\2\2KL\7\'\2\2"+
		"L\32\3\2\2\2MN\7+\2\2N\34\3\2\2\2OS\7%\2\2PR\n\2\2\2QP\3\2\2\2RU\3\2\2"+
		"\2SQ\3\2\2\2ST\3\2\2\2TV\3\2\2\2US\3\2\2\2VW\b\17\2\2W\36\3\2\2\2XZ\t"+
		"\3\2\2YX\3\2\2\2Z \3\2\2\2[\\\t\4\2\2\\\"\3\2\2\2]^\7\13\2\2^$\3\2\2\2"+
		"_d\5\37\20\2`c\5\37\20\2ac\5!\21\2b`\3\2\2\2ba\3\2\2\2cf\3\2\2\2db\3\2"+
		"\2\2de\3\2\2\2e&\3\2\2\2fd\3\2\2\2gi\5!\21\2hg\3\2\2\2ij\3\2\2\2jh\3\2"+
		"\2\2jk\3\2\2\2k(\3\2\2\2lm\5-\27\2mn\3\2\2\2no\b\25\2\2o*\3\2\2\2pq\6"+
		"\26\2\2q}\5-\27\2rt\7\17\2\2sr\3\2\2\2st\3\2\2\2tu\3\2\2\2ux\7\f\2\2v"+
		"x\4\16\17\2ws\3\2\2\2wv\3\2\2\2xz\3\2\2\2y{\5-\27\2zy\3\2\2\2z{\3\2\2"+
		"\2{}\3\2\2\2|p\3\2\2\2|w\3\2\2\2}~\3\2\2\2~\177\b\26\3\2\177,\3\2\2\2"+
		"\u0080\u0082\t\5\2\2\u0081\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084.\3\2\2\2\r\2SYbdjswz|\u0083\4\b\2\2"+
		"\3\26\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}