package com.ffi_benchmark;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.SymbolLookup;
import static java.lang.foreign.ValueLayout.JAVA_INT;
import java.lang.invoke.MethodHandle;

public class AdditionFFI {
    static {
        System.loadLibrary("adderffi");
    }

    public int addCppFFI(int a, int b) {
        Linker linker = Linker.nativeLinker();
        SymbolLookup loaderLookup = SymbolLookup.loaderLookup();

        try {
            MethodHandle addfunction = linker.downcallHandle(
                loaderLookup.find("add").orElseThrow(),
                FunctionDescriptor.of(JAVA_INT, JAVA_INT, JAVA_INT)
            );

            return (int) addfunction.invokeExact(a, b);  
        } catch (Throwable e) {
            e.printStackTrace();
            return 0;
        }
    }
}