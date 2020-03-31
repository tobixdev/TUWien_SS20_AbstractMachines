package com.oracle.truffle.sl.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

import java.util.LinkedList;
import java.util.List;

public class SuiteNode extends StatementNode {
    @Children
    private StatementNode[] statementNodes;

    public SuiteNode (StatementNode[] statementNodes){
        this.statementNodes = statementNodes;
    }

    @Override
    public void executeVoid(VirtualFrame frame) {
        for (StatementNode node : statementNodes)
            node.executeVoid(frame);
    }
}
