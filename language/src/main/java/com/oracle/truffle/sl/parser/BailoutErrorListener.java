package com.oracle.truffle.sl.parser;

import com.oracle.truffle.api.source.Source;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class BailoutErrorListener extends BaseErrorListener {
    private Source source;

    public BailoutErrorListener(Source source) {
        this.source = source;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        throw new RingelnatterParseError(source, line, charPositionInLine + 1, 1, msg);
    }
}
