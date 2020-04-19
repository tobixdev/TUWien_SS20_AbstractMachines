package com.oracle.truffle.sl.matching;

import com.oracle.truffle.sl.runtime.ListTruffleObject;

import java.util.List;

public class SingleElementListMatcher extends Matcher {
    private Matcher matcher;

    public SingleElementListMatcher(Matcher matcher) {
        this.matcher = matcher;
    }

    @Override
    public MatchingResult matchesList(ListTruffleObject value) {
        if(value.getArraySize() != 1)
            return new MatchingResult(false);
        return matcher.matches(value.readArrayElement(0));
    }
}
