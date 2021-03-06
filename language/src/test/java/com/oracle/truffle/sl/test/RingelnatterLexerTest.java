package com.oracle.truffle.sl.test;

import com.oracle.truffle.sl.parser.RingelnatterLexer;
import com.oracle.truffle.sl.parser.RingelnatterParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RingelnatterLexerTest {
    private static class ErrorListener implements ANTLRErrorListener{
        public void syntaxError(Recognizer<?, ?> recognizer, Object o, int line, int position, String msg, RecognitionException e) {
            System.err.format("Syntax Error (at line %d): %s : %s %n", line, msg, position);
        }

        public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {
            System.err.format("Ambiguity: %s - %s %n", dfa.toLexerString(), parser.getCurrentToken().getText());
        }

        public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {}
        public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {}
    }

    private final static ErrorListener errorListener = new ErrorListener();

    @Test
    public void lexer_fromEmptyString_returnEmptyList() throws IOException {
        List<Token> tokens = getTokensFromText("");

        assertThat(tokens.size(), is(1));
        assertThat(tokens.get(0).getType(), is(RingelnatterLexer.EOF));
    }

    @Test
    public void lexer_identifiesNumber() throws IOException {
        List<Token> tokens = getTokensFromText("01234");

        assertThat(tokens.size(), is(2));
        assertThat(tokens.get(0).getType(), is(RingelnatterLexer.NUMERIC_LITERAL));
        assertThat(tokens.get(0).getText(), is("01234"));
        assertThat(tokens.get(1).getType(), is(RingelnatterLexer.EOF));
    }

    @Test
    public void lexer_identifiesIdentifiers() throws IOException {
        List<Token> tokens = getTokensFromText("hallo123_$");

        assertThat(tokens.size(), is(2));
        assertThat(tokens.get(0).getType(), is(RingelnatterLexer.IDENTIFIER));
        assertThat(tokens.get(0).getText(), is("hallo123_"));
        assertThat(tokens.get(1).getType(), is(RingelnatterLexer.EOF));
    }

    @Test
    public void lexer_identifiesLineComment() throws IOException {
        List<Token> tokens = getTokensFromText("#helloooo");

        assertThat(tokens.size(), is(1));
        assertThat(tokens.get(0).getType(), is(RingelnatterLexer.EOF));
    }

    @Test
    public void lexer_indents() throws IOException {
        List<Token> tokens = getTokensFromText("xyz\n"+
                "   xyz\n");

        assertThat(tokens.size(), is(7));
        assertThat(tokens.get(0).getType(), is(RingelnatterLexer.IDENTIFIER));
        assertThat(tokens.get(1).getType(), is(RingelnatterLexer.NEWLINE));
        assertThat(tokens.get(2).getType(), is(RingelnatterParser.INDENT));
        assertThat(tokens.get(3).getType(), is(RingelnatterLexer.IDENTIFIER));
        assertThat(tokens.get(4).getType(), is(RingelnatterLexer.NEWLINE));
        assertThat(tokens.get(5).getType(), is(RingelnatterParser.DEDENT));
        assertThat(tokens.get(6).getType(), is(RingelnatterLexer.EOF));
    }

    @Test
    public void lexer_indentsWithNoNewLine() throws IOException {
        List<Token> tokens = getTokensFromText("xyz\n"+
                "   xyz");

        assertThat(tokens.size(), is(7));
        assertThat(tokens.get(0).getType(), is(RingelnatterLexer.IDENTIFIER));
        assertThat(tokens.get(1).getType(), is(RingelnatterLexer.NEWLINE));
        assertThat(tokens.get(2).getType(), is(RingelnatterParser.INDENT));
        assertThat(tokens.get(3).getType(), is(RingelnatterLexer.IDENTIFIER));
        assertThat(tokens.get(4).getType(), is(RingelnatterLexer.NEWLINE));
        assertThat(tokens.get(5).getType(), is(RingelnatterParser.DEDENT));
        assertThat(tokens.get(6).getType(), is(RingelnatterLexer.EOF));
    }

    @Test
    public void lexer_indentsNested() throws IOException {
        List<Token> tokens = getTokensFromText("xyz\n"+
                "  xyz\n" +
                "    xyz");

        assertThat(tokens.size(), is(11));
        assertThat(tokens.get(0).getType(), is(RingelnatterLexer.IDENTIFIER));
        assertThat(tokens.get(1).getType(), is(RingelnatterLexer.NEWLINE));
        assertThat(tokens.get(2).getType(), is(RingelnatterParser.INDENT));
        assertThat(tokens.get(3).getType(), is(RingelnatterLexer.IDENTIFIER));
        assertThat(tokens.get(4).getType(), is(RingelnatterLexer.NEWLINE));
        assertThat(tokens.get(5).getType(), is(RingelnatterParser.INDENT));
        assertThat(tokens.get(6).getType(), is(RingelnatterLexer.IDENTIFIER));
        assertThat(tokens.get(7).getType(), is(RingelnatterLexer.NEWLINE));
        assertThat(tokens.get(8).getType(), is(RingelnatterParser.DEDENT));
        assertThat(tokens.get(9).getType(), is(RingelnatterParser.DEDENT));
        assertThat(tokens.get(10).getType(), is(RingelnatterLexer.EOF));
    }

    @Test
    public void lexer_moreComplex() throws IOException {
        List<Token> tokens = getTokensFromText("fn main():\n" +
                "  let a = 100\n" +
                "  if a > 100:\n" +
                "    ret 1\n" +
                "  ret 0\n");

        assertThat(tokens.size(), is(27));
        assertThat(tokens.get(0).getText(), is("fn"));
        assertThat(tokens.get(1).getText(), is("main"));
        assertThat(tokens.get(2).getText(), is("("));
        assertThat(tokens.get(3).getText(), is("):"));
        assertThat(tokens.get(4).getType(), is(RingelnatterLexer.NEWLINE));
        assertThat(tokens.get(5).getType(), is(RingelnatterParser.INDENT));
        assertThat(tokens.get(6).getText(), is("let"));
        assertThat(tokens.get(7).getText(), is("a"));
        assertThat(tokens.get(8).getText(), is("="));
        assertThat(tokens.get(9).getText(), is("100"));
        assertThat(tokens.get(10).getType(), is(RingelnatterLexer.NEWLINE));
        assertThat(tokens.get(11).getText(), is("if"));
        assertThat(tokens.get(12).getText(), is("a"));
        assertThat(tokens.get(13).getText(), is(">"));
        assertThat(tokens.get(14).getText(), is("100"));
        assertThat(tokens.get(15).getText(), is(":"));
        assertThat(tokens.get(16).getType(), is(RingelnatterLexer.NEWLINE));
        assertThat(tokens.get(17).getType(), is(RingelnatterParser.INDENT));
        assertThat(tokens.get(18).getText(), is("ret"));
        assertThat(tokens.get(19).getText(), is("1"));
        assertThat(tokens.get(20).getType(), is(RingelnatterLexer.NEWLINE));
        assertThat(tokens.get(21).getType(), is(RingelnatterParser.DEDENT));
        assertThat(tokens.get(22).getText(), is("ret"));
        assertThat(tokens.get(23).getText(), is("0"));
        assertThat(tokens.get(24).getType(), is(RingelnatterLexer.NEWLINE));
        assertThat(tokens.get(25).getType(), is(RingelnatterParser.DEDENT));
        assertThat(tokens.get(26).getType(), is(RingelnatterLexer.EOF));
    }

    private List<Token> getTokensFromText(String txt) throws IOException {
        ByteArrayInputStream iStream = new ByteArrayInputStream(txt.getBytes());
        CharStream cStream = CharStreams.fromStream(iStream);
        Lexer lex = new RingelnatterLexer(cStream);
        lex.addErrorListener(errorListener);
        CommonTokenStream tokenStream = new CommonTokenStream(lex);
        tokenStream.fill();
        return tokenStream.getTokens();
    }
}
