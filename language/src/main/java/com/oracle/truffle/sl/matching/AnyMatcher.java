package com.oracle.truffle.sl.matching;

import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.sl.runtime.ListTruffleObject;

import java.util.LinkedList;

public class AnyMatcher extends Matcher {
    private FrameSlot bindTo;

    public AnyMatcher(FrameSlot bindTo) {
        this.bindTo = bindTo;
    }

    @Override
    public MatchingResult matchesLong(long value) {
        VariableDefinitions definitions = new VariableDefinitions();
        definitions.add(bindTo, value);
        return new MatchingResult(true, definitions);
    }

    @Override
    public MatchingResult matchesList(ListTruffleObject value) {
        VariableDefinitions definitions = new VariableDefinitions();
        definitions.add(bindTo, value);
        return new MatchingResult(true, definitions);
    }
}
