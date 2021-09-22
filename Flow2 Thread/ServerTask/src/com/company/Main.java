package com.company;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static CopyOnWriteArrayList<User> users = new CopyOnWriteArrayList<User>();


    public static void main(String[] args) {
        // write your code here
        Quiz quiz = new Quiz();


        EchoServer echoServer = new EchoServer(2345,quiz);
        try {
            echoServer.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
