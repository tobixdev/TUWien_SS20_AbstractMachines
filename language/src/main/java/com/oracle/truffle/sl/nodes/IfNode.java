package com.oracle.truffle.sl.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.sl.nodes.expression.ConditionalNode;

public class IfNode extends StatementNode {

    @Child
    private ConditionalNode conditionNode;

    @Child
    private SuiteNode thenPartNode;

    public IfNode(ConditionalNode conditionNode, SuiteNode thenPartNode) {
        this.conditionNode = conditionNode;
        this.thenPartNode = thenPartNode;
    }

    @Override
    public void executeVoid(VirtualFrame frame) {
        if((boolean) conditionNode.executeGeneric(frame))
            thenPartNode.executeVoid(frame);
    }
}
