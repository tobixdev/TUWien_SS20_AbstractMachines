package com.oracle.truffle.sl.matching;

import com.oracle.truffle.sl.runtime.ListTruffleObject;

public class EmptyListMatcher extends Matcher {

    @Override
    public MatchingResult matchesList(ListTruffleObject value) {
        return new MatchingResult(value.getArraySize() == 0);
    }
}
