package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.sl.RingelnatterLanguage;
import com.oracle.truffle.sl.nodes.ExpressionNode;

public final class InvokeNode extends ExpressionNode {
    private final String functionName;
    @Children private final ExpressionNode[] argumentNodes;

    public InvokeNode(String functionName, ExpressionNode[] argumentNodes) {
        this.functionName = functionName;
        this.argumentNodes = argumentNodes;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        RootCallTarget target = lookupContextReference(RingelnatterLanguage.class).get()
                .getFunctionRegistry()
                .lookup(functionName, argumentNodes.length);

        Object[] argumentValues = new Object[argumentNodes.length];
        for (int i = 0; i < argumentNodes.length; i++) {
            argumentValues[i] = argumentNodes[i].executeGeneric(frame);
        }

        return target.call(argumentValues);
    }
}
