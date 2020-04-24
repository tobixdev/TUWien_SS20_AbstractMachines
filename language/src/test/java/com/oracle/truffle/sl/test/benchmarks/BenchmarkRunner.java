package com.oracle.truffle.sl.test.benchmarks;

import com.oracle.truffle.sl.RingelnatterLanguage;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Fork(0)
public class BenchmarkRunner {
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

   // @Benchmark
  //  @BenchmarkMode(Mode.AverageTime)
    public void fibonacci() throws IOException {
        String result = runRnglFile("fibonacci");
        assert result.equals("");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void findMax() throws IOException {
        String result = runRnglFile("find_max");
        assert result.equals("");
    }

    private String runRnglFile(String name) throws IOException {
        Path rnglFile = Paths.get("language", "src","test", "programs", "benchmarks", name + ".rngl");
        try (Context context = Context.create(RingelnatterLanguage.ID)) {
            Source source = Source.newBuilder(RingelnatterLanguage.ID, rnglFile.toFile()).build();
            return context.eval(source).toString();
        }
    }
}
