package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.sl.RingelnatterException;
import com.oracle.truffle.sl.nodes.ExpressionNode;

public class EvalNode extends ExpressionNode {
    @Children private EvalArmNode[] arms;

    public EvalNode(EvalArmNode[] arms) {
        this.arms = arms;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        for (EvalArmNode armNode : arms) {
            if(armNode.doesGuardHold(frame))
                return armNode.executeGeneric(frame);
        }
        throw new RingelnatterException("No arm of the eval construct matched. Consider adding a fallback ('_') arm.");
    }
}
