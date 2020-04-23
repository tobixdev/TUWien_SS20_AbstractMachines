package com.oracle.truffle.sl.test.programs;

import com.oracle.truffle.sl.RingelnatterLanguage;
import com.oracle.truffle.sl.parser.RingelnatterLexer;
import com.oracle.truffle.sl.test.RingelnatterLexerTest;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RingelnatterProgramTest {
    protected void runRnglFile(String name) throws IOException {
        Path resourceDirectory = Paths.get("src","test", "programs", name + ".rngl");
        String expectedOutput = Files.readAllLines(resourceDirectory).get(0).substring(2);
        Context context = Context.create();
        Source source = Source.newBuilder(RingelnatterLanguage.ID, resourceDirectory.toFile()).build();
        assertThat(context.eval(source).toString(), is(expectedOutput));
    }

    protected String executeProgram(String program) {
        Context context = Context.create();
        return context.eval(RingelnatterLanguage.ID, program).toString();
    }

    protected String executeExpression(String expr) {
        return executeProgram("fn main():\n" + "  ret " + expr + "\n");
    }

    protected String executeVariableBoundInExpression(String expr, String variableName) {
        return executeProgram("fn main():\n"+
                "  if " + expr + ":\n" +
                "    ret " + variableName);
    }
}
