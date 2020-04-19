package com.oracle.truffle.sl.matching;

import com.oracle.truffle.sl.runtime.ListTruffleObject;

public class Matcher {
    public MatchingResult matches(Object value) {
        if (value.getClass() == Long.class)
            return matchesLong((long) value);
        else if (value.getClass() == ListTruffleObject.class)
            return matchesList((ListTruffleObject) value);
        return new MatchingResult(false);
    }

    public MatchingResult matchesLong(long value) {
        return new MatchingResult(false);
    }

    public MatchingResult matchesList(ListTruffleObject value) {
        return new MatchingResult(false);
    }
}
