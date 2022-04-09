package dev.larrybattle.grpc.calculator.client;

import dev.larrybattle.grpc.calculator.CalculatorGrpc;
import dev.larrybattle.grpc.calculator.CalculatorRequest;
import dev.larrybattle.grpc.calculator.CalculatorResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class CalculatorClient {
    public static void main(String[] args) {
        System.out.println("Started client");

        // create channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        // creating stub
        CalculatorGrpc.CalculatorBlockingStub stub = CalculatorGrpc.newBlockingStub(channel);

        // create request
        CalculatorRequest request = CalculatorRequest.newBuilder().setA(3).setB(8).build();

        // send request
        CalculatorResponse response = stub.addTwoNumbers(request);

        // view response
        System.out.println("response => " + response.getSum());

        System.out.println("end of client");

    }
}
