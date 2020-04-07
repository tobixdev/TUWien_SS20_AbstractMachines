package com.oracle.truffle.sl.test.programs;

import com.oracle.truffle.sl.RingelnatterLanguage;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class RingelnatterProgramTest {
    protected String executeProgram(String program) {
        Context context = Context.create();
        return context.eval(RingelnatterLanguage.ID, program).toString();
    }

    protected String executeExpression(String s) {
        return executeProgram("fn main():\n" + "\tret " + s + "\n");
    }
}
