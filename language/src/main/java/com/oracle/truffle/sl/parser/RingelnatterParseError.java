package com.oracle.truffle.sl.parser;

import com.oracle.truffle.api.TruffleException;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.source.SourceSection;

public class RingelnatterParseError extends RuntimeException implements TruffleException {

    public static final long serialVersionUID = 1L;
    private final Source source;
    private final int line;
    private final int column;
    private final int length;

    public RingelnatterParseError(Source source, int line, int column, int length, String message) {
        super(message);
        this.source = source;
        this.line = line;
        this.column = column;
        this.length = length;
    }

    @Override
    public SourceSection getSourceLocation() {
        try {
            return source.createSection(line, column, length);
        } catch (Exception ex) {
            return source.createUnavailableSection();
        }
    }

    @Override
    public Node getLocation() {
        return null;
    }

    @Override
    public boolean isSyntaxError() {
        return true;
    }
}
