package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.sl.RingelnatterException;
import com.oracle.truffle.sl.nodes.ExpressionNode;

public class EvalArmNode extends ExpressionNode {
    @Child private ConditionalNode guard;
    @Child private ExpressionNode value;

    public EvalArmNode(ConditionalNode guard, ExpressionNode value) {
        this.guard = guard;
        this.value = value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        if (doesGuardHold(frame)) {
            return value.executeGeneric(frame);
        }
        throw new RingelnatterException("Called execute on eval arm with negative guard condition");
    }

    public boolean doesGuardHold(VirtualFrame frame) {
        return (boolean) guard.executeGeneric(frame);
    }
}
