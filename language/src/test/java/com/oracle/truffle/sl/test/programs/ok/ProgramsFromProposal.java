package com.oracle.truffle.sl.test.programs.ok;

import org.junit.Test;

import java.io.IOException;

public class ProgramsFromProposal extends RingelnatterProgramTest {

    @Override
    protected String directory() {
        return "ok/proposal";
    }

    @Test
    public void add() throws IOException {
        runRnglFileWithEmbeddedResult("add");
    }

    @Test
    public void concat() throws IOException {
        runRnglFileWithEmbeddedResult("concat");
    }

    @Test
    public void is_list() throws IOException {
        runRnglFileWithEmbeddedResult("is_list");
    }

    @Test
    public void is_num() throws IOException {
        runRnglFileWithEmbeddedResult("is_num");
    }

    @Test
    public void multiply_list() throws IOException {
        runRnglFileWithEmbeddedResult("multiply_list");
    }

    @Test
    public void multiply_list2() throws IOException {
        runRnglFileWithEmbeddedResult("multiply_list2");
    }

    @Test
    public void fib() throws IOException {
        runRnglFileWithEmbeddedResult("fib");
    }

    @Test
    public void zero_list() throws IOException {
        runRnglFileWithEmbeddedResult("zero_list");
    }

    @Test
    public void split_odd_and_even() throws IOException {
        runRnglFileWithEmbeddedResult("split_odd_and_even");
    }

    @Test
    public void tail() throws IOException {
        runRnglFileWithEmbeddedResult("tail");
    }

    @Test
    public void head() throws IOException {
        runRnglFileWithEmbeddedResult("head");
    }

    @Test
    public void len() throws IOException {
        runRnglFileWithEmbeddedResult("len");
    }
}
