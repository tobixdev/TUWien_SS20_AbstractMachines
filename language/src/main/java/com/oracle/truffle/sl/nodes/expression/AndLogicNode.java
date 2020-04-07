package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(shortName = "&&")
public abstract class AndLogicNode extends LogicBinaryNode {
    @Specialization
    protected long and(long left, long right) {
        return fromTruthValue(toTruthValue(left) && toTruthValue(right));
    }
}
