package com.oracle.truffle.sl.test.programs;

import org.junit.Test;

import java.io.IOException;

public class ProgramsFromProposal extends RingelnatterProgramTest {
    @Test
    public void add() throws IOException {
        runRnglFile("add");
    }

    @Test
    public void concat() throws IOException {
        runRnglFile("concat");
    }

    @Test
    public void is_list() throws IOException {
        runRnglFile("is_list");
    }

    @Test
    public void is_num() throws IOException {
        runRnglFile("is_num");
    }

    @Test
    public void multiply_list() throws IOException {
        runRnglFile("multiply_list");
    }

    @Test
    public void multiply_list2() throws IOException {
        runRnglFile("multiply_list2");
    }

    @Test
    public void fib() throws IOException {
        runRnglFile("fib");
    }

    @Test
    public void zero_list() throws IOException {
        runRnglFile("zero_list");
    }

    @Test
    public void split_odd_and_even() throws IOException {
        runRnglFile("split_odd_and_even");
    }

    @Test
    public void tail() throws IOException {
        runRnglFile("tail");
    }

    @Test
    public void head() throws IOException {
        runRnglFile("head");
    }

    @Test
    public void len() throws IOException {
        runRnglFile("len");
    }
}
