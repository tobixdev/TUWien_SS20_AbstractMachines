package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(shortName = "+")
public abstract class AddNode extends BinaryNode {
    @Specialization
    @CompilerDirectives.TruffleBoundary
    protected long add(long left, long right) {
        return Math.addExact(left, right);
    }
}
