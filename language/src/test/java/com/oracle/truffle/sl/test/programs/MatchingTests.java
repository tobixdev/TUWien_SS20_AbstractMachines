package com.oracle.truffle.sl.test.programs;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatchingTests extends RingelnatterProgramTest {
    @Test
    public void matchNumber_true() {
        assertThat (executeExpression("1 matches 1"), is("1"));
    }

    @Test
    public void matchNumer_false() {
        assertThat (executeExpression("2 matches 1"), is("0"));
    }

    @Test
    public void matchEmptyList_true() {
        assertThat (executeExpression("[] matches []"), is("1"));
    }

    @Test
    public void matchEmptyList_false() {
        assertThat (executeExpression("[1] matches []"), is("0"));
    }

    @Test
    public void matchSingleElementList_true() {
        assertThat (executeExpression("[1] matches [a]"), is("1"));
    }

    @Test
    public void matchSingleElementList_false() {
        assertThat (executeExpression("[] matches [a]"), is("0"));
        assertThat (executeExpression("[1,2] matches [a]"), is("0"));
    }

    @Test
    public void matchList_true() {
        assertThat (executeExpression("[1,2] matches [a.b]"), is("1"));
        assertThat (executeExpression("[1] matches [a.b]"), is("1"));
        assertThat (executeExpression("[1,2,3,4] matches [a.b]"), is("1"));
        assertThat (executeExpression("[1,2,3,4] matches [a.b.c.d]"), is("1"));
        assertThat (executeExpression("[1,2,3,4] matches [a.b.c.d.f]"), is("1"));
    }

    @Test
    public void matchList_false() {
        assertThat (executeExpression("[] matches [a.b]"), is("0"));
        assertThat (executeExpression("[1] matches [a.b.c]"), is("0"));
        assertThat (executeExpression("[1,2,3,4] matches [a.b.c.d.e.f]"), is("0"));
    }

    @Test
    public void matchSingleElementList_bindsIdentifier() {
        assertThat (executeVariableBoundInExpression("[1] matches [a]", "a"), is("1"));
        assertThat (executeVariableBoundInExpression("[123] matches [a]", "a"), is("123"));
        assertThat (executeVariableBoundInExpression("[0] matches [a]", "a"), is("0"));
    }

    @Test
    public void matchList_bindsIdentifiers() {
        assertThat (executeVariableBoundInExpression("[1,2] matches [head.tail]", "head"), is("1"));
        assertThat (executeVariableBoundInExpression("[1,2] matches [head.tail]", "tail"), is("[2]"));
        assertThat (executeVariableBoundInExpression("[1,2,3,4] matches [a.b.c.d]", "a"), is("1"));
        assertThat (executeVariableBoundInExpression("[1,2,3,4] matches [a.b.c.d]", "b"), is("2"));
        assertThat (executeVariableBoundInExpression("[1,2,3,4] matches [a.b.c.d]", "c"), is("3"));
        assertThat (executeVariableBoundInExpression("[1,2,3,4] matches [a.b.c.d]", "d"), is("[4]"));
        assertThat (executeVariableBoundInExpression("[1] matches [head.tail]", "tail"), is("[]"));
    }
}
