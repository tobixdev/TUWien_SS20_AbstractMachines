package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.sl.nodes.ExpressionNode;

@NodeChild("opNode")
public abstract class UnaryNode extends ExpressionNode {
}
