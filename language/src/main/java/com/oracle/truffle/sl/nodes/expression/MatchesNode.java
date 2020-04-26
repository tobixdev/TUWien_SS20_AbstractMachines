package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotKind;
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
            writeToStackSlot(frame, entry);
        }
        return result.matches() ? (long) 1 : (long) 0;
    }

    private void writeToStackSlot(VirtualFrame frame, VariableDefinitions.Entry entry) {
        Object value = entry.getObject();
        FrameSlot slot = entry.getSlot();
        if(value.getClass() == Long.class) {
            frame.getFrameDescriptor().setFrameSlotKind(slot, FrameSlotKind.Long);
            frame.setLong(slot, (long) value);
        } else if (value.getClass() == ListTruffleObject.class) {
            frame.getFrameDescriptor().setFrameSlotKind(slot, FrameSlotKind.Object);
            frame.setObject(slot, value);
        } else {
            throw new UnsupportedOperationException("Unknown value type");
        }
    }
}
