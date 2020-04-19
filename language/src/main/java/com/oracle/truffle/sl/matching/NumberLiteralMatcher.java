package com.oracle.truffle.sl.matching;

public class NumberLiteralMatcher extends Matcher {
    private long expectedValue;

    public NumberLiteralMatcher(long expectedValue) {
        this.expectedValue = expectedValue;
    }

    @Override
    public MatchingResult matchesLong(long value) {
        return new MatchingResult(expectedValue == value);
    }
}
