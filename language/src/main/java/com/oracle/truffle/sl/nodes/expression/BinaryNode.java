package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.sl.nodes.ExpressionNode;

@NodeChild("leftNode")
@NodeChild("rightNode")
public abstract class BinaryNode extends ExpressionNode {
}
