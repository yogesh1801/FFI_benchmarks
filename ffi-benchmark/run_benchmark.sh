mvn package
java -Djava.library.path=target --enable-native-access=ALL-UNNAMED -jar target/benchmarks.jar