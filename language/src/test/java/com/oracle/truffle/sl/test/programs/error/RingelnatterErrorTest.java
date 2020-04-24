package com.oracle.truffle.sl.test.programs.error;

import com.oracle.truffle.sl.test.programs.ok.RingelnatterProgramTest;
import org.graalvm.polyglot.PolyglotException;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class RingelnatterErrorTest extends RingelnatterProgramTest {
    protected void expectError(String name, String cause) throws IOException {
        try {
            runRnglFile(name);
            fail("Should not be reached");
        }catch (PolyglotException ex) {
            assertThat(ex.getMessage(), containsString(cause));
        }
    }
}
