package com.oracle.truffle.sl.matching;

import com.oracle.truffle.api.frame.FrameSlot;

import java.util.LinkedList;

public class VariableDefinitions {
    private LinkedList<Entry> variables = new LinkedList<>();

    public void add(FrameSlot slot, Object object) {
        variables.add(new Entry(slot, object));
    }

    public void addAll(VariableDefinitions variableDefinitions) {
        variables.addAll(variableDefinitions.variables);
    }

    public int size() {
        return variables.size();
    }

    public Entry get(int i) {
        return variables.get(i);
    }

    public class Entry {
        private com.oracle.truffle.api.frame.FrameSlot slot;
        private Object object;

        public Entry(com.oracle.truffle.api.frame.FrameSlot slot, Object object) {
            this.slot = slot;
            this.object = object;
        }

        public com.oracle.truffle.api.frame.FrameSlot getSlot() {
            return slot;
        }

        public Object getObject() {
            return object;
        }
    }
}
