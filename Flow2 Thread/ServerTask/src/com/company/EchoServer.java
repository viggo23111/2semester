package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class EchoServer {
    private int port;
    Quiz quiz;


    public EchoServer(int port, Quiz quiz) {
        this.port = port;
        this.quiz = quiz;
    }

    public void startServer() throws IOException {
        BlockingQueue<String> messages = new ArrayBlockingQueue<>(10);
        CopyOnWriteArrayList<ClientHandler> clientQueue = new CopyOnWriteArrayList<ClientHandler>();

        Dispatcher dis = new Dispatcher(messages,clientQueue);
        ServerSocket serverSocket = new ServerSocket(port);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        while (true) {
            Socket client = serverSocket.accept();
            ClientHandler cl = new ClientHandler(client,messages,quiz);
            clientQueue.add(cl);
            executorService.execute(cl);
            executorService.execute(dis);
        }
    }
}
