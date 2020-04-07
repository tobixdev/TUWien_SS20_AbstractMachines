package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.sl.nodes.ExpressionNode;

public abstract class LogicBinaryNode extends BinaryNode {
    protected boolean toTruthValue(long value){
        return value != 0;
    }

    protected long fromTruthValue(boolean value){
        return value ? 1 : 0;
    }
}
