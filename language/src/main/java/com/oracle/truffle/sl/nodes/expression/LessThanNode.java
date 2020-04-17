package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(shortName = "<")
public abstract class LessThanNode extends LogicBinaryNode {
    @Specialization
    protected long lessThan(long left, long right) {
        return fromTruthValue(left < right);
    }
}
