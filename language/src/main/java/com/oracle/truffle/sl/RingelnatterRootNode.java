package com.oracle.truffle.sl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

public class RingelnatterRootNode extends RootNode {
    @CompilerDirectives.CompilationFinal
    private final String name;
    @Child
    private FunctionBodyNode bodyNode;

    public RingelnatterRootNode(RingelnatterLanguage language, FrameDescriptor frameDescriptor, String name, FunctionBodyNode bodyNode) {
        super(language, frameDescriptor);
        this.name = name;
        this.bodyNode = bodyNode;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return bodyNode.executeVoid(frame);
    }

    @Override
    public String getName() {
        return name;
    }
}
