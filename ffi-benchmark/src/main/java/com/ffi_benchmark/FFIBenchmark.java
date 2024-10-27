package com.ffi_benchmark;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)

public class FFIBenchmark {

    private Addition addition;
    private Fibbonaci fibbonaci;
    private FlatBufferDemo flatBufferDemo;
    
    @Setup
    public void setup() {
        addition = new Addition();
        fibbonaci = new Fibbonaci();
        flatBufferDemo = new FlatBufferDemo();
    }

    @Benchmark
    public int addJava() {
        return addition.addJava(10, 10);
    }

    @Benchmark
    public long addCpp() {
        return addition.addCpp(10, 10);
    }

    @Benchmark
    public long fiboJava() {
        return fibbonaci.fibboJava(15);
    }

    @Benchmark
    public long fiboCpp() {
        return fibbonaci.fibboCpp(15);
    }

    @Benchmark
    public void writeUserData() {
        flatBufferDemo.writeUserData();
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}
