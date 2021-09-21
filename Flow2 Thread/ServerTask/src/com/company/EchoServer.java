package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class EchoServer {
    private int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void startServer() throws IOException {
        //TODO lav message køen
        BlockingQueue<String> messages = new ArrayBlockingQueue<>(10);
        //TODO lav listen til clienthandlers
        CopyOnWriteArrayList<ClientHandler> clientQueue = new CopyOnWriteArrayList<ClientHandler>();

        //TODO instatiate disppatcheren med de delte ressourcer(Køen og copyonarray)
        Dispatcher dis = new Dispatcher(messages,clientQueue);
        ServerSocket serverSocket = new ServerSocket(port);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        while (true) {
            Socket client = serverSocket.accept();
            //TODO LAV CL MED DELT RESSOURCE
            ClientHandler cl = new ClientHandler(client,messages);
            //TODO put cl i listen
            clientQueue.add(cl);
            executorService.execute(cl);
            executorService.execute(dis);
        }
    }
}
