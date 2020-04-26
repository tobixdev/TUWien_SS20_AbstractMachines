package com.oracle.truffle.sl.test.programs.ok;

import org.junit.Test;

import java.io.IOException;

public class RuntimeTests extends RingelnatterProgramTest {

    @Override
    protected String directory() {
        return "ok/runtime";
    }

    @Test
    public void noReturn() throws IOException {
        runRnglFileWithEmbeddedResult("no_return");
    }

    @Test
    public void listChangedByCalledFunction() throws IOException {
        runRnglFileWithEmbeddedResult("list_changed_by_called_function");
    }
}
