package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class Dispatcher implements Runnable {
    BlockingQueue<String> messages;
    CopyOnWriteArrayList<ClientHandler> clientQueue;

    public Dispatcher(BlockingQueue<String> messages, CopyOnWriteArrayList<ClientHandler> clientQueue) {
        this.messages = messages;
        this.clientQueue = clientQueue;
    }

    @Override
    public void run() {
        String outmsg = "";
        while (true) {
            try {
                outmsg = messages.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (ClientHandler clientHandler : clientQueue) {
                clientHandler.getPw().println(outmsg);
            }
        }
    }
}
