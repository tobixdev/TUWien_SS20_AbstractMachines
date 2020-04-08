package com.oracle.truffle.sl.runtime;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.sl.RingelnatterException;

import java.util.HashMap;
import java.util.Map;

public class RingelnatterFunctionRegistry {
    private final Map<String, RootCallTarget> functions = new HashMap<>();

    public RootCallTarget lookup(String name, int parameterCount) {
        String key = name + "$" + parameterCount;
        if(!functions.containsKey(key))
            throw new RingelnatterException("Function " + name + " with " + parameterCount + " parameters not defined");
        return functions.get(key);
    }

    public void register(String name, int parameterCount, RootCallTarget callTarget) {
        String key = name + "$" + parameterCount;
        if(functions.containsKey(key))
            throw new RingelnatterException("Function " + name + " with " + parameterCount + " already defined");
        functions.put(key, callTarget);
    }
}
