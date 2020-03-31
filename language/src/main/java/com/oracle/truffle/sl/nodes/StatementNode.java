package com.oracle.truffle.sl.nodes;

import com.oracle.truffle.api.dsl.ReportPolymorphism;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.sl.RingelnatterLanguage;

@NodeInfo(language = RingelnatterLanguage.ID)
@ReportPolymorphism
public abstract class StatementNode extends Node {
    public abstract void executeVoid(VirtualFrame frame);
}
