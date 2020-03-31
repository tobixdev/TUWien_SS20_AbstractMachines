package com.oracle.truffle.sl.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

public final class ReturnNode extends StatementNode {

    @Child private ExpressionNode valueNode;

    public ReturnNode(ExpressionNode valueNode) {
        this.valueNode = valueNode;
    }

    @Override
    public void executeVoid(VirtualFrame frame) {
        Object result;
        if (valueNode != null) {
            result = valueNode.executeGeneric(frame);
        } else {
            result = 0L;
        }
        throw new ReturnException(result);
    }
}
