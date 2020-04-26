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
import java.util.Arrays;

@Fork(0)
public class BenchmarkRunnerForJava {
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void fibonacci() throws IOException {
        long result = fibonacci(35);
        if(result != 9227465)
            throw new RuntimeException("Benchmark result was not correct (" + result + ")");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void findMax() throws IOException {
        long result = findMax_100000();
        if(result != 3931)
            throw new RuntimeException("Benchmark result was not correct (" + result + ")");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void sort() throws IOException {
        sort_1000();
    }

    private long findMax_100000() {
        long result = 0;

        for (int i = 0; i < 100_000; i++) {
            long [] arr = {1,3,53,34,24,624,3931,2134,21,34,315,325,24,6,456,2,34,234,234,624,6,234,2,412,34,34,247,34,745,345,3246};
            result = findMax(arr);
        }

        return result;
    }

    private long findMax(long[] arr) {
        long max = 0;
        for (long l : arr) {
            max = Math.max(l, max);
        }
        return max;
    }

    private void sort_1000() {
        for (int i = 0; i < 1_000; i++) {
            long [] arr = {456,3,53,34,24,624,3931,2134,21,34,315,325,24,6,1,2,34,234,234,624,6,234,2,412,34,34,247,34,745,345,3246};
            sort(arr);
        }
    }

    private void sort(long[] arr) {
        Arrays.sort(arr);
    }

    private long fibonacci(long n) {
        return n < 3 ? 1 : fibonacci(n - 2) + fibonacci(n - 1);
    }
}
