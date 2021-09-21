package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // write your code here

        EchoServer echoServer = new EchoServer(2345);
        try {
            echoServer.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
