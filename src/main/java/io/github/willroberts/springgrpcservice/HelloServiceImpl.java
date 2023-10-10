package io.github.willroberts.springgrpcservice;

import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
	@Override
	public void hello(HelloRequest req, StreamObserver<HelloResponse> respObserver) {
		String body = new StringBuilder()
				.append("Hello, ")
				.append(req.getName())
				.append("!")
				.toString();

		HelloResponse resp = HelloResponse.newBuilder()
				.setResp(body)
				.build();

		respObserver.onNext(resp);
		respObserver.onCompleted();
	}
}
