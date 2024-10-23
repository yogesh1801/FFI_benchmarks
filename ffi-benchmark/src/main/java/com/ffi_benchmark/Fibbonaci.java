package com.ffi_benchmark;

public class Fibbonaci {
    static {
        System.loadLibrary("fibbonaci");
    }

    public native long fibboCpp(long n);

    public long fibboJava(long n) {
        if (n <= 1) return n;
        return fibboJava(n-1) + fibboJava(n-2);
    }
}