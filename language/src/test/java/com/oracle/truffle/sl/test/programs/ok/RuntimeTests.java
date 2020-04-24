package com.oracle.truffle.sl.test.programs.ok;

import org.junit.Test;

import java.io.IOException;

public class RuntimeTests extends RingelnatterProgramTest {

    @Override
    protected String directory() {
        return "ok/runtime";
    }

    @Test
    public void noMainMethod() throws IOException {
        runRnglFileWithEmbeddedResult("no_return");
    }
}
