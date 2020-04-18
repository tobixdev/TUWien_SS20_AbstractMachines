package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.sl.nodes.ExpressionNode;
import com.oracle.truffle.sl.runtime.ListTruffleObject;

@NodeChild("child")
public abstract class ConditionalNode extends ExpressionNode {
    @Specialization
    public boolean isTrue(long child) {
        return child != 0;
    }

    @Specialization
    public boolean isTrue(ListTruffleObject child) {
        return child.getArraySize() > 0;
    }
}
