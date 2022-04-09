package dev.larrybattle.grpc.calculator.service;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class CalculatorService {

    private static final int PORT = 50051;

    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Started service");

        // start service
        Server server = ServerBuilder.forPort(PORT)
                .addService(new CalculatorImpl())
                .build();

        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdown));

        // end when needed
        server.awaitTermination();
        // view response
        System.out.println("End of service");
    }
}
