package com.oracle.truffle.sl.matching;

import java.util.List;

public class MatchingResult {
    public static MatchingResult combine(MatchingResult left, MatchingResult right) {
        boolean matches = left.matches && right.matches;
        if(!matches)
            return new MatchingResult(false);
        left.matchedVariables.addAll(right.matchedVariables);
        return new MatchingResult(true, left.matchedVariables);
    }

    private boolean matches;
    private VariableDefinitions matchedVariables;

    public MatchingResult(boolean matches) {
        this.matches = matches;
        this.matchedVariables = new VariableDefinitions();
    }

    public MatchingResult(boolean matches, VariableDefinitions matchedVariables) {
        this.matches = matches;
        this.matchedVariables = matchedVariables;
    }

    public VariableDefinitions getMatchedVariables() {
        return matchedVariables;
    }

    public boolean matches() {
        return matches;
    }
}
