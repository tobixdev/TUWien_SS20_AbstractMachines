package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.sl.nodes.ExpressionNode;
import com.oracle.truffle.sl.runtime.ListTruffleObject;

import java.util.LinkedList;

public final class ListNode extends ExpressionNode {
    @Children private final ExpressionNode[] values;

    public ListNode(ExpressionNode[] value) {
        this.values = value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        ListTruffleObject list = new ListTruffleObject();
        for (ExpressionNode expr : values) {
            list.add(expr.executeGeneric(frame));
        }
        return list;
    }
}
