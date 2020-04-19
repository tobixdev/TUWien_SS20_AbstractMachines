package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.sl.nodes.ExpressionNode;
import com.oracle.truffle.sl.runtime.ListTruffleObject;

@NodeInfo(shortName = "is")
public abstract class IsNode extends UnaryNode {
    private enum Type {
        Number,
        List
    }

    private final Type checkFor;

    public IsNode(String checkForTypeName) {
        if ("number".equals(checkForTypeName))
            this.checkFor = Type.Number;
        else if ("list".equals(checkForTypeName))
            this.checkFor = Type.List;
        else
            throw new UnsupportedOperationException("Type name " + checkForTypeName + " not supported");
    }

    @Specialization
    protected long is(long op) {
        return checkFor == Type.Number ? 1 : 0;
    }

    @Specialization
    protected long is(ListTruffleObject op) {
        return checkFor == Type.List ? 1 : 0;
    }
}
