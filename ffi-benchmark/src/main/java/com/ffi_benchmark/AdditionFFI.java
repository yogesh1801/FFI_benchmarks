package com.ffi_benchmark;
import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import static java.lang.foreign.ValueLayout.JAVA_INT;
import java.lang.invoke.MethodHandle;

public class AdditionFFI {
    static {
        System.loadLibrary("adderffi");
    }

    public static int addCppFFI(int a, int b) throws Throwable {
        try(Arena arena = Arena.ofConfined()) {
            MemorySegment nativeA = arena.allocate(JAVA_INT);
            MemorySegment nativeB = arena.allocate(JAVA_INT);

            nativeA.set(JAVA_INT, 0, a);
            nativeB.set(JAVA_INT, 0, b);

            Linker linker = Linker.nativeLinker();

            SymbolLookup lookup = SymbolLookup.loaderLookup();
            MemorySegment add_addr = lookup.find("add").get();

            FunctionDescriptor add_sig = FunctionDescriptor.of(JAVA_INT, JAVA_INT, JAVA_INT);

            MethodHandle addin = linker.downcallHandle(add_addr, add_sig);

            int result = (int)addin.invokeExact(nativeA.get(JAVA_INT,0), nativeB.get(JAVA_INT, 0));
            return result;
        } catch (Throwable e){
            e.printStackTrace();
            return 0;
        }
    }
}