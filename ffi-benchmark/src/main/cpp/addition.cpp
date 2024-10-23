#include "com_ffi_benchmark_Addition.h"

JNIEXPORT jint JNICALL Java_com_ffi_1benchmark_Addition_addCpp
  (JNIEnv *env, jobject obj, jint a, jint b) {
    return a + b;
  }

