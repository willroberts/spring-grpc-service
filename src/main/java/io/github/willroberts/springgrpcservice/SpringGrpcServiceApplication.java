package io.github.willroberts.springgrpcservice;

import java.io.IOException;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

@SpringBootApplication
public class SpringGrpcServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringGrpcServiceApplication.class, args);

		Server server = ServerBuilder
				.forPort(8000)
				.addService(new HelloServiceImpl())
				.addService(ProtoReflectionService.newInstance())
				.build();

		try {
			System.out.println("Starting gRPC server on localhost:8000");
			server.start();
		} catch (Exception e) {
			System.out.println("Failed to start gRPC server:" + e);
		}

		try {
			System.out.println("Listening for requests");
			server.awaitTermination();
		} catch (Exception e) {
			System.out.println("Error during gRPC server operation:" + e);
		}
	}
}