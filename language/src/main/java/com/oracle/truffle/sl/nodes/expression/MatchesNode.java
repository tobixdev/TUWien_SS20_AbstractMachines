package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.sl.matching.Matcher;
import com.oracle.truffle.sl.matching.MatchingResult;
import com.oracle.truffle.sl.matching.VariableDefinitions;
import com.oracle.truffle.sl.nodes.ExpressionNode;
import com.oracle.truffle.sl.nodes.WriteLocalVariableNodeGen;
import com.oracle.truffle.sl.runtime.ListTruffleObject;

@NodeInfo(shortName = "is")
public final class MatchesNode extends UnaryNode {
    private final Matcher matcher;
    private final ExpressionNode inner;

    public MatchesNode (Matcher matcher, ExpressionNode inner) {
        this.matcher = matcher;
        this.inner = inner;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        Object innerResult = inner.executeGeneric(frame);
        MatchingResult result = matcher.matches(innerResult);
        for (int i = 0; i < result.getMatchedVariables().size(); i++) {
            VariableDefinitions.Entry entry = result.getMatchedVariables().get(i);
            ExpressionNode valueNode = getValueNode(entry.getObject());
            WriteLocalVariableNodeGen.create(valueNode, entry.getSlot()).executeGeneric(frame);
        }
        return result.matches() ? (long) 1 : (long) 0;
    }

    protected ExpressionNode getValueNode(Object object){
        if(object.getClass() == Long.class)
            return new LongValueNode((long) object);
        if(object.getClass() == ListTruffleObject.class)
            return new ListValueNode((ListTruffleObject) object);
        throw new UnsupportedOperationException("Value type no known.");
    }
}
