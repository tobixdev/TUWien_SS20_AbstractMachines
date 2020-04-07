package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(shortName = "!")
public abstract class NotNode extends UnaryNode {
    @Specialization
    protected long not(long op) {
        return op == 0 ? 1 : 0;
    }
}
