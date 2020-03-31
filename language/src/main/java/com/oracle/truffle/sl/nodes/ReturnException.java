package com.oracle.truffle.sl.nodes;

import com.oracle.truffle.api.nodes.ControlFlowException;

public class ReturnException extends ControlFlowException {
    private Object value;

    public ReturnException (Object value){
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}
