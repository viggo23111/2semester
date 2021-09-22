package com.company;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

	// write your code here

        EchoServer echoServer = new EchoServer(2345);
        echoServer.startServer();
    }
}
