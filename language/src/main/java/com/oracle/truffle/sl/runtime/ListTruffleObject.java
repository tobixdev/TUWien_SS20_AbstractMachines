package com.oracle.truffle.sl.runtime;

import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;
import com.oracle.truffle.sl.nodes.ExpressionNode;

import java.util.LinkedList;
import java.util.List;

@ExportLibrary(InteropLibrary.class)
public class ListTruffleObject implements TruffleObject {
    private LinkedList<Object> elements;

    public ListTruffleObject() {
        this(new LinkedList<>());
    }

    public ListTruffleObject(LinkedList<Object> elements) {
        this.elements = elements;
    }

    public void add(Object element) {
        elements.add(element);
    }

    public void addAll(ListTruffleObject element) {
        elements.addAll(element.elements);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for (Object object : elements) {
            sb.append(object.toString()).append(',');
        }
        if(elements.size() > 0)
            sb.setLength(sb.length() - 1);
        sb.append(']');
        return sb.toString();
    }

    public ListTruffleObject subList (int fromIndex, int toIndex) {
        List<Object> subList = elements.subList(fromIndex, toIndex);
        LinkedList<Object> linkedList = new LinkedList<>(subList);
        return new ListTruffleObject(linkedList);
    }

    @ExportMessage
    public boolean hasArrayElements() {
        return true;
    }

    @ExportMessage
    public long getArraySize() {
        return elements.size();
    }

    @ExportMessage
    public boolean isArrayElementReadable(long index) {
        return true;
    }

    @ExportMessage
    public Object readArrayElement(long index) {
        return elements.get((int) index);
    }
}
