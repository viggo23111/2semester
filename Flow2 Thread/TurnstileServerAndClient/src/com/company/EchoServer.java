package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class EchoServer {
    private int port;
    static final int NUMBER_OF_TURNSTILES = 40;

    static Turnstile[] turnStiles = new Turnstile[NUMBER_OF_TURNSTILES];

    public EchoServer(int port) {
        this.port = port;
    }

    public void startServer() throws IOException {
        TurnstileCounter sharedCounter = new TurnstileCounter();

        for (int i = 0; i < NUMBER_OF_TURNSTILES; i++) {
            turnStiles[i] = new Turnstile(sharedCounter);
        }
        ServerSocket serverSocket = new ServerSocket(port);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        while (true) {
            Socket client = serverSocket.accept();
            ClientHandler cl = new ClientHandler(client,sharedCounter,turnStiles);
            executorService.execute(cl);
        }
    }
}
