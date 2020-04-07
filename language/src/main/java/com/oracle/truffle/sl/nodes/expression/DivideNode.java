package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(shortName = "/")
public abstract class DivideNode extends BinaryNode {
    @Specialization
    protected long divide(long left, long right) {
        return left / right;
    }
}
