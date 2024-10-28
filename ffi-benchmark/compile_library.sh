export JAVA_HOME="C:/Program Files/Java/jdk-23"
export FLAT_BUFF="C:/flatbuffers"

mvn clean install
mvn compile

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

g++ -shared \
    -I "$JAVA_HOME/include" \
    -I "$JAVA_HOME/include/win32" \
    -I "$FLAT_BUFF/include" \
    -o target/flatbufferdemo.dll \
    src/main/cpp/flatbufferdemo.cpp

g++ -shared \
    -o target/adderffi.dll \
    -Wl,--add-stdcall-alias src/main/cpp/adderffi.cpp 