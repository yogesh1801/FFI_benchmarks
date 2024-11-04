# Foreign Function Interface (FFI) in Java

source - https://docs.oracle.com/en/java/javase/23/core/foreign-function-and-memory-api.html

## Overview
FFI is a mechanism that allows functions written in one programming language to be called from another language. In Java, this is primarily accomplished through the Java Native Interface (JNI).

## Concepts

### 1. Foreign Function Interface (FFI)
- **Definition**: FFI allows code written in one programming language to call functions or use services from another language, enabling interoperability.

### 2. Java Native Interface (JNI)
- **Purpose**: JNI is a specific implementation of FFI that enables Java code to call applications and libraries written in C and C++.
- **Usage**: It allows Java programs to access native methods, providing capabilities that are not directly available in the Java Virtual Machine (JVM).
  
### 3.  Native Methods
- **Definition**: Methods implemented in a language other than Java (e.g., C or C++).
- **Declaration**: Use the `native` keyword to declare these methods in Java.
  
  **Format**:
  ```java
  public native returnType methodName(parameterType parameterName);
  ```
- **Loading native Library**: This helps us to dynamically loading written in another language into Java application at runtime. (All the native methods are called from this library).

- # Questions
- 1. Why JNI is not safe?


