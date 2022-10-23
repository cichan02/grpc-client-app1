package by.piskunou.grpccourse;

import by.piskunou.grpccourse.GreetingServiceGrpc.GreetingServiceBlockingStub;
import by.piskunou.grpccourse.GreetingServiceOuterClass.HelloRequest;
import by.piskunou.grpccourse.GreetingServiceOuterClass.HelloResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {
	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
													  .usePlaintext()
													  .build();
		GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);
		HelloRequest request = HelloRequest.newBuilder()
										   .setName("Cichan")
										   .build();
		HelloResponse response =  stub.greeting(request);
		System.out.println(response);
		channel.shutdownNow();
	}
}
