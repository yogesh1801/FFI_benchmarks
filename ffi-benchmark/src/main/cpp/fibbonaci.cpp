#include "com_ffi_benchmark_Fibbonaci.h"

JNIEXPORT jlong JNICALL Java_com_ffi_1benchmark_Fibbonaci_fibboCpp
  (JNIEnv *env, jobject obj, jlong n) {
    if(n <= 1) return n;
    return Java_com_ffi_1benchmark_Fibbonaci_fibboCpp(nullptr, nullptr, n-1) + Java_com_ffi_1benchmark_Fibbonaci_fibboCpp(nullptr, nullptr, n-1);
  }