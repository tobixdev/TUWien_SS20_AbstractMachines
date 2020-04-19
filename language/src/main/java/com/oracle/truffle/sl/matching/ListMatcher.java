package com.oracle.truffle.sl.matching;

import com.oracle.truffle.sl.runtime.ListTruffleObject;

import java.util.List;

public class ListMatcher extends Matcher {
    private List<Matcher> matchers;

    public ListMatcher(List<Matcher> matchers) {
        this.matchers = matchers;
    }

    @Override
    public MatchingResult matchesList(ListTruffleObject value) {
        if(value.getArraySize() < matchers.size() - 1)
            return new MatchingResult(false);
        MatchingResult matching = new MatchingResult(true);
        for (int i = 0; i < matchers.size() - 1; i++) {
            matching = matchSingleValue(matching, i, value);
        }

        return matchTail(matching, value);
    }

    private MatchingResult matchSingleValue (MatchingResult matching, int i, ListTruffleObject list) {
        Matcher matcher = matchers.get(i);
        Object valueToMatch = list.readArrayElement(i);
        return MatchingResult.combine(matching, matcher.matches(valueToMatch));
    }

    private MatchingResult matchTail(MatchingResult matching, ListTruffleObject value) {
        ListTruffleObject tail = value.subList(matchers.size() - 1, (int) value.getArraySize());
        Matcher matcher = matchers.get(matchers.size() - 1);
        return MatchingResult.combine(matching, matcher.matchesList(tail));
    }
}
