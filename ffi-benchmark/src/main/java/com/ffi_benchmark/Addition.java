package com.ffi_benchmark;

public class Addition {
    static {
        System.loadLibrary("addition");
    }

    public int addJava (int a, int b) {
        return a + b;
    }

    public native int addCpp (int a, int b);
}
