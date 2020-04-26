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

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void fibonacci() throws IOException {
        String result = runRnglFile("fibonacci");
        if(!result.equals("9227465"))
            throw new RuntimeException("Benchmark result was not correct (" + result + ")");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void findMax() throws IOException {
        String result = runRnglFile("find_max");
        if(!result.equals("3931"))
            throw new RuntimeException("Benchmark result was not correct (" + result + ")");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void sort() throws IOException {
        String result = runRnglFile("sort");
        if(!result.equals("[1,2,2,3,6,6,21,24,24,34,34,34,34,34,34,53,234,234,234,247,315,325,345,412,456,624,624,745,2134,3246,3931]"))
            throw new RuntimeException("Benchmark result was not correct (" + result + ")");
    }

    private String runRnglFile(String name) throws IOException {
        Path rnglFile = Paths.get("language", "src","test", "programs", "benchmarks", name + ".rngl");
        try (Context context = Context.create(RingelnatterLanguage.ID)) {
            Source source = Source.newBuilder(RingelnatterLanguage.ID, rnglFile.toFile()).build();
            return context.eval(source).toString();
        }
    }
}
