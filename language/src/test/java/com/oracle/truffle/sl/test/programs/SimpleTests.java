package com.oracle.truffle.sl.test.programs;

import com.oracle.truffle.sl.RingelnatterLanguage;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleTests extends RingelnatterProgramTest {
    @Test
    public void returnConstant() {
        String result = executeProgram("fn main():\n" +
                "\tret 1\n");
        assertThat (result, is("1"));
    }

    @Test
    public void simpleAddition() {
        String result = executeProgram("fn main():\n" +
                "\tret 19 + 3\n");
        assertThat (result, is("22"));
    }

    @Test
    public void simpleSubtraction() {
        String result = executeProgram("fn main():\n" +
                "\tret 19 - 3\n");
        assertThat (result, is("16"));
    }

    @Test
    public void simpleMultiplication() {
        String result = executeProgram("fn main():\n" +
                "\tret 10 * 3\n");
        assertThat (result, is("30"));
    }

    @Test
    public void simpleDivision() {
        String result = executeProgram("fn main():\n" +
                "\tret 10 / 3\n");
        assertThat (result, is("3"));
    }

    @Test
    public void simpleExpression() {
        String result = executeProgram("fn main():\n" +
                "\tret (10 - 3 * 2) + 4\n");
        assertThat (result, is("8"));
    }

    @Test
    public void returnVariable() {
        String result = executeProgram("fn main():\n" +
                "\tlet a = 10\n" +
                "\tret a\n");
        assertThat (result, is("10"));
    }

    @Test
    public void returnComplexVariables() {
        String result = executeProgram("fn main():\n" +
                "\tlet a = 100\n" +
                "\tlet b = a * 3\n" +
                "\tlet c = a + b\n" +
                "\tlet d = 50\n" +
                "\tret c - d\n");
        assertThat (result, is("350"));
    }
}
