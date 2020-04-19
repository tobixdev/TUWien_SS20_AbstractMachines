package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.sl.nodes.ExpressionNode;
import com.oracle.truffle.sl.runtime.ListTruffleObject;

import java.util.LinkedList;

public final class ListNode extends ExpressionNode {
    private final LinkedList<ExpressionNode> values;

    public ListNode(LinkedList<ExpressionNode> value) {
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
