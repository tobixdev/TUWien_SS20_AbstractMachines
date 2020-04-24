package com.oracle.truffle.sl;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.sl.nodes.ReturnException;
import com.oracle.truffle.sl.nodes.SuiteNode;

public class FunctionBodyNode extends Node {
    @Child private SuiteNode suiteNode;

    public FunctionBodyNode(SuiteNode suiteNode) {
        this.suiteNode = suiteNode;
    }

    public Object executeVoid(VirtualFrame frame){
        try{
            suiteNode.executeVoid(frame);
        } catch (ReturnException ex){
            return ex.getValue();
        }
        return 0L;
    }
}