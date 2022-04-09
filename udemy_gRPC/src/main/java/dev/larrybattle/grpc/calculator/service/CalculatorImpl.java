package dev.larrybattle.grpc.calculator.service;

import dev.larrybattle.grpc.calculator.CalculatorGrpc;
import dev.larrybattle.grpc.calculator.CalculatorRequest;
import dev.larrybattle.grpc.calculator.CalculatorResponse;
import io.grpc.stub.StreamObserver;

public class CalculatorImpl extends CalculatorGrpc.CalculatorImplBase {
    @Override
    public void addTwoNumbers(CalculatorRequest request, StreamObserver<CalculatorResponse> responseObserver) {
        int sum = request.getA() + request.getB();

        CalculatorResponse response = CalculatorResponse.newBuilder().setSum(sum).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
