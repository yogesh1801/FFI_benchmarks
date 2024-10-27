#include "com_ffi_benchmark_FlatBufferDemo.h"
#include "person_generated.h"  

JNIEXPORT void JNICALL Java_com_ffi_1benchmark_FlatBufferDemo_readFlatBufferCpp
  (JNIEnv *env, jobject obj, jbyteArray arr) {
    
    jbyte* buffer = env->GetByteArrayElements(arr, nullptr);
    jsize length = env->GetArrayLength(arr);

    
    const uint8_t* flatbuf = reinterpret_cast<const uint8_t*>(buffer);
    
  
    
    if (1) {
    
        auto person = GetPerson(flatbuf);
      
        const char* name = person->name()->c_str();
        const char* gender = person->gender()->c_str();
        int32_t age = person->age();
    }

    env->ReleaseByteArrayElements(arr, buffer, JNI_ABORT);
}