package io.github.willroberts.springgrpcservice;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

@SpringBootApplication
public class SpringGrpcServiceApplication {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(SpringGrpcServiceApplication.class.getName());

		SpringApplication.run(SpringGrpcServiceApplication.class, args);

		Server server = ServerBuilder
				.forPort(8000)
				.addService(new HelloServiceImpl())
				.addService(ProtoReflectionService.newInstance())
				.build();

		try {
			logger.info("Starting gRPC server on localhost:8000");
			server.start();
		} catch (Exception e) {
			logger.info("Failed to start gRPC server:" + e);
			return;
		}

		try {
			logger.info("Listening for requests");
			server.awaitTermination();
		} catch (Exception e) {
			logger.info("Error during gRPC server operation:" + e);
		}
	}
}