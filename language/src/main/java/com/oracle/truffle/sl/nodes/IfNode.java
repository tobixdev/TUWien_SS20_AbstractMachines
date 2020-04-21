package com.oracle.truffle.sl.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.sl.nodes.expression.ConditionalNode;

public final class IfNode extends StatementNode {

    @Child
    private ConditionalNode conditionNode;

    @Child
    private SuiteNode thenNode;
    @Child
    private StatementNode elseNode;

    public IfNode(ConditionalNode conditionNode, SuiteNode thenNode) {
        this.conditionNode = conditionNode;
        this.thenNode = thenNode;
    }

    public IfNode(ConditionalNode conditionNode, SuiteNode thenNode, StatementNode elseNode) {
        this.conditionNode = conditionNode;
        this.thenNode = thenNode;
        this.elseNode = elseNode;
    }

    @Override
    public void executeVoid(VirtualFrame frame) {
        if((boolean) conditionNode.executeGeneric(frame)) {
            thenNode.executeVoid(frame);
        } else if (elseNode != null) {
            elseNode.executeVoid(frame);
        }
    }
}
