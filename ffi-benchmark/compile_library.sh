export JAVA_HOME="C:/Program Files/Java/jdk-23"

g++ -shared \
    -I "$JAVA_HOME/include" \
    -I "$JAVA_HOME/include/win32" \
    -o target/addition.dll \
    src/main/cpp/addition.cpp

g++ -shared \
    -I "$JAVA_HOME/include" \
    -I "$JAVA_HOME/include/win32" \
    -o target/fibbonaci.dll \
    src/main/cpp/fibbonaci.cpp
