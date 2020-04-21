package com.oracle.truffle.sl.test.programs;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ControlFlowTests extends RingelnatterProgramTest {
    @Test
    public void ifstmnt_true() {
        String result = executeProgram("fn main():\n" +
                "  let a = 100\n" +
                "  if a > 99:\n" +
                "    ret 1\n" +
                "  ret 0\n");
        assertThat (result, is("1"));
    }

    @Test
    public void ifstmnt_false() {
        String result = executeProgram("fn main():\n" +
                "  let a = 100\n" +
                "  if a > 100:\n" +
                "    ret 1\n" +
                "  ret 0\n");
        assertThat (result, is("0"));
    }

    @Test
    public void ifelsechain() {
        String result = executeProgram("fn main():\n" +
                "  ret [a(1), a(2), a(3), a(0)]\n" +
                "\n" +
                "fn a(x):\n" +
                "  let res = 0\n" +
                "  if x == 1:\n" +
                "    res = 101\n" +
                "  elif x == 2:\n" +
                "    res = 102\n" +
                "  elif x > 2:\n" +
                "    res = 103\n" +
                "  else:\n" +
                "    res = 99\n" +
                "  ret res\n");
        assertThat (result, is("[101,102,103,99]"));
    }

    @Test
    public void ifelsechain_noElse() {
        String result = executeProgram("fn main():\n" +
                "  ret [a(1), a(2), a(3), a(0)]\n" +
                "\n" +
                "fn a(x):\n" +
                "  let res = 0\n" +
                "  if x == 1:\n" +
                "    res = 101\n" +
                "  elif x == 2:\n" +
                "    res = 102\n" +
                "  ret res\n");
        assertThat (result, is("[101,102,0,0]"));
    }

    @Test
    public void whilestmnt_true() {
        String result = executeProgram("fn main():\n" +
                "  let a = 100\n" +
                "  let b = 0\n" +
                "  while a > 50:\n" +
                "    a = a - 1\n" +
                "    b = b + 1\n" +
                "  ret b\n");
        assertThat (result, is("50"));
    }

    @Test
    public void whilestmnt_false() {
        String result = executeProgram("fn main():\n" +
                "  let a = 100\n" +
                "  let b = 0\n" +
                "  while a < 0:\n" +
                "    a = a - 1\n" +
                "    b = b + 1\n" +
                "  ret b\n");
        assertThat (result, is("0"));
    }
}
