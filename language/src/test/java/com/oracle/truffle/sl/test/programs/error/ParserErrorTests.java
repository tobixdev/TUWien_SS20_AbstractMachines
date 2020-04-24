package com.oracle.truffle.sl.test.programs.error;

import org.junit.Test;

import java.io.IOException;

public class ParserErrorTests extends RingelnatterErrorTest {
    @Test
    public void use_semicolon() throws IOException {
        expectError("use_semicolon", ";");
    }

    @Test
    public void no_indent_fn() throws IOException {
        expectError("no_indent_fn", "missing INDENT");
    }

    @Test
    public void empty_function() throws IOException {
        expectError("empty_function_1", "expecting NEWLINE");
        expectError("empty_function_2", "expecting INDENT");
        expectError("empty_function_3", "expecting INDENT");
    }

    @Test
    public void eval_no_arms() throws IOException {
        expectError("eval_without_arm", "mismatched input 'ret' expecting INDENT");
    }

    @Test
    public void elif_after_else() throws IOException {
        expectError("elif_after_else", "extraneous input 'elif' expecting");
    }

    @Override
    protected String directory() {
        return "error/parser";
    }
}
