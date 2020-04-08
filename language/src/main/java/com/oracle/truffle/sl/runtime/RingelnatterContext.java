package com.oracle.truffle.sl.runtime;

public class RingelnatterContext {
    private RingelnatterFunctionRegistry functionRegistry;

    public RingelnatterContext() {
        functionRegistry = new RingelnatterFunctionRegistry();
    }

    public RingelnatterFunctionRegistry getFunctionRegistry() {
        return functionRegistry;
    }
}
