package com.oracle.truffle.sl.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.sl.nodes.expression.ConditionalNode;

public class WhileNode extends StatementNode {

    @Child
    private ConditionalNode conditionNode;

    @Child
    private SuiteNode thenPartNode;

    public WhileNode(ConditionalNode conditionNode, SuiteNode loopBody) {
        this.conditionNode = conditionNode;
        this.thenPartNode = loopBody;
    }

    @Override
    public void executeVoid(VirtualFrame frame) {
        while ((boolean) conditionNode.executeGeneric(frame))
            thenPartNode.executeVoid(frame);
    }
}
