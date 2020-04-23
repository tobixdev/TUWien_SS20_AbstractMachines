package com.oracle.truffle.sl.test.programs;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleTests extends RingelnatterProgramTest {
    @Test
    public void returnConstant() {
        assertThat (executeExpression("1"), is("1"));
    }

    @Test
    public void simpleAddition() {
        assertThat (executeExpression("19 + 3"), is("22"));
    }

    @Test
    public void simpleSubtraction() {
        assertThat (executeExpression("19 - 3"), is("16"));
    }

    @Test
    public void simpleMultiplication() {
        assertThat (executeExpression("10 * 3"), is("30"));
    }

    @Test
    public void simpleMod() {
        assertThat (executeExpression("10 % 3"), is("1"));
    }

    @Test
    public void simpleDivision() {
        assertThat (executeExpression("10 / 3"), is("3"));
    }

    @Test
    public void simpleLessThan() {
        assertThat (executeExpression("10 < 3"), is("0"));
        assertThat (executeExpression("3 < 10"), is("1"));
        assertThat (executeExpression("3 < 3"), is("0"));
    }

    @Test
    public void simpleGreaterThan() {
        assertThat (executeExpression("10 > 3"), is("1"));
        assertThat (executeExpression("3 > 10"), is("0"));
        assertThat (executeExpression("3 > 3"), is("0"));
    }

    @Test
    public void simpleLessThanOrEqual() {
        assertThat (executeExpression("10 <= 3"), is("0"));
        assertThat (executeExpression("3 <= 10"), is("1"));
        assertThat (executeExpression("3 <= 3"), is("1"));
    }

    @Test
    public void simpleGreaterThanOrEqual() {
        assertThat (executeExpression("10 >= 3"), is("1"));
        assertThat (executeExpression("3 >= 10"), is("0"));
        assertThat (executeExpression("3 >= 3"), is("1"));
    }

    @Test
    public void simpleEqual() {
        assertThat (executeExpression("10 == 3"), is("0"));
        assertThat (executeExpression("3 == 3"), is("1"));
    }

    @Test
    public void simpleNotEqual() {
        assertThat (executeExpression("10 != 3"), is("1"));
        assertThat (executeExpression("3 != 3"), is("0"));
    }

    @Test
    public void simpleNot() {
        assertThat (executeExpression("!3"), is("0"));
        assertThat (executeExpression("!(10 - 10)"), is("1"));
    }

    @Test
    public void simpleAnd() {
        assertThat (executeExpression("0 && 0"), is("0"));
        assertThat (executeExpression("0 && 1"), is("0"));
        assertThat (executeExpression("1 && 0"), is("0"));
        assertThat (executeExpression("1 && 1"), is("1"));
    }

    @Test
    public void simpleOr() {
        assertThat (executeExpression("0 || 0"), is("0"));
        assertThat (executeExpression("0 || 1"), is("1"));
        assertThat (executeExpression("1 || 0"), is("1"));
        assertThat (executeExpression("1 || 1"), is("1"));
    }

    @Test
    public void simpleIs() {
        assertThat (executeExpression("3 is number"), is("1"));
        assertThat (executeExpression("3 is list"), is("0"));
        assertThat (executeExpression("[] is number"), is("0"));
        assertThat (executeExpression("[] is list"), is("1"));
    }

    @Test
    public void simpleExpression() {
        assertThat (executeExpression("(10 - 3 * 2) + 4"), is("8"));
    }

    @Test
    public void simpleLogicalExpression() {
        assertThat (executeExpression("10 - 4 - 6 || (1 && 5 - 4)"), is("1"));
    }

    @Test
    public void simpleList_empty() {
        assertThat (executeExpression("[]"), is("[]"));
    }

    @Test
    public void simpleList_one() {
        assertThat (executeExpression("[1]"), is("[1]"));
    }

    @Test
    public void simpleList_multiple() {
        assertThat (executeExpression("[1,2+5]"), is("[1,7]"));
    }

    @Test
    public void simpleList_nested() {
        assertThat (executeExpression("[1,[2,3]]"), is("[1,[2,3]]"));
    }

    @Test
    public void simpleConcatenation() {
        assertThat (executeExpression("1.2"), is("[1,2]"));
    }

    @Test
    public void simpleConcatenation_appendedToList() {
        assertThat (executeExpression("([1]).2"), is("[1,2]"));
    }

    @Test
    public void callFunction() {
        String result = executeProgram("fn main():\n" +
                "  ret x()\n" +
                "\n" +
                "fn x():\n" +
                "  ret 10\n");
        assertThat (result, is("10"));
    }

    @Test
    public void callFunction_WithVar() {
        String result = executeProgram("fn main():\n" +
                "  ret x(10)\n" +
                "\n" +
                "fn x(a):\n" +
                "  ret a\n");
        assertThat (result, is("10"));
    }

    @Test
    public void callFunction_InList() {
        String result = executeProgram("fn main():\n" +
                "  ret [x(10)]\n" +
                "\n" +
                "fn x(a):\n" +
                "  ret a\n");
        assertThat (result, is("[10]"));
    }

    @Test
    public void returnVariable() {
        String result = executeProgram("fn main():\n" +
                "  let a = 10\n" +
                "  ret a\n");
        assertThat (result, is("10"));
    }

    @Test
    public void assignment() {
        String result = executeProgram("fn main():\n" +
                "  let a = 10\n" +
                "  a = 0\n" +
                "  ret a\n");
        assertThat (result, is("0"));
    }

    @Test
    public void eval() {
        String result = executeProgram("fn main():\n" +
                "  let x = [10]\n" +
                "  ret eval:\n" +
                "    x matches []: 0\n" +
                "    x matches [9]: 9\n" +
                "    x matches [a.10]: 11\n" +
                "    x matches [a]: a\n");
        assertThat (result, is("10"));
    }

    @Test
    public void eval_fallback() {
        String result = executeProgram("fn main():\n" +
                "  let x = [10]\n" +
                "  ret eval:\n" +
                "    x matches []: 0\n" +
                "    _: 123");
        // TODO Error case no match
        assertThat (result, is("123"));
    }

    @Test
    public void returnComplexVariables() {
        String result = executeProgram("fn main():\n" +
                "  let a = 100\n" +
                "  let b = a * 3\n" +
                "  let c = a + b\n" +
                "  let d = 50\n" +
                "  ret c - d\n");
        assertThat (result, is("350"));
    }
}
