package com.oracle.truffle.sl;

import com.oracle.truffle.api.dsl.TypeSystem;
import com.oracle.truffle.sl.runtime.ListTruffleObject;

import java.util.LinkedList;

@TypeSystem({long.class, ListTruffleObject.class})
public class RingelnatterTypes {
    public RingelnatterTypes() {
    }
}
