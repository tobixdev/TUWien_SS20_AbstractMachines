package com.oracle.truffle.sl.test.programs.ok;

import com.oracle.truffle.sl.RingelnatterLanguage;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public abstract class RingelnatterProgramTest {
    protected String directory() {
        return "";
    }

    protected void runRnglFileWithEmbeddedResult(String name) throws IOException {
        Path rnglFile = Paths.get("src","test", "programs", directory(), name + ".rngl");
        String expectedOutput = Files.readAllLines(rnglFile).get(0).substring(2);
        assertThat(runRnglFile(name), is(expectedOutput));
    }

    protected String runRnglFile(String name) throws IOException {
        Path rnglFile = Paths.get("src","test", "programs", directory(), name + ".rngl");
        try (Context context = Context.create()) {
            Source source = Source.newBuilder(RingelnatterLanguage.ID, rnglFile.toFile()).build();
            return context.eval(source).toString();
        }
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
