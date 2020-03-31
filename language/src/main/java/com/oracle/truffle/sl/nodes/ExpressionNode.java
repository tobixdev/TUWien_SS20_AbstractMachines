package com.oracle.truffle.sl.nodes;

import com.oracle.truffle.api.dsl.TypeSystemReference;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.sl.RingelnatterTypes;

@TypeSystemReference(RingelnatterTypes.class)
public abstract class ExpressionNode extends StatementNode {
    public abstract Object executeGeneric(VirtualFrame frame);

    @Override
    public void executeVoid(VirtualFrame frame) {
        executeGeneric(frame);
    }
}
