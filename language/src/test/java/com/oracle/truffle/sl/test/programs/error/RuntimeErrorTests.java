package com.oracle.truffle.sl.test.programs.error;

import org.junit.Test;

import java.io.IOException;

public class RuntimeErrorTests extends RingelnatterErrorTest {
    @Override
    protected String directory() {
        return "error/runtime";
    }

    @Test
    public void noMainMethod() throws IOException {
        expectError("no_main_method", "No main method found");
    }

    @Test
    public void noMatchForEval() throws IOException {
        expectError("no_match_for_eval", "No arm of the eval construct matched.");
    }
}
