package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.sl.nodes.ExpressionNode;
import com.oracle.truffle.sl.runtime.ListTruffleObject;

@NodeInfo(shortName = ".")
public final class ConcatNode extends ExpressionNode {

    @Children private final ExpressionNode[] children;

    public ConcatNode(ExpressionNode[] children) {
        this.children = children;
    }

    @Override
    @ExplodeLoop
    public Object executeGeneric(VirtualFrame frame) {
        ListTruffleObject list = new ListTruffleObject();
        for (ExpressionNode child : children) {
            Object obj = child.executeGeneric(frame);
            if (obj.getClass() == ListTruffleObject.class)
                list.addAll((ListTruffleObject) obj);
            else
                list.add(obj);
        }
        return list;
    }
}
