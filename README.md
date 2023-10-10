# spring-grpc-service

This is an example gRPC service using Java 21 and the Spring Boot framework.

The service's protobuf interface is compiled to both Java and C++ by Gradle.

## Setup

Use SDKMAN to install Java 21 and Gradle 8.4:
```
sdk install java 21-graalce && sdk default java 21-graalce
sdk install gradle 8.4 && sdk default gradle 8.4
```

## Running the Server

Build and run:
```
./gradlew build
java -jar build/libs/spring-grpc-service-0.0.1-SNAPSHOT.jar
```

Run without building:
```
./gradlew bootRun
```

You can now send gRPC requests to `localhost:8000`:
```
$ grpcurl -plaintext -d '{"name": "Alice"}' localhost:8000 io.github.willroberts.springgrpcservice.HelloService/hello
{
  "resp": "Hello, Alice"
}
```