package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Stadium {
    TurnstileCounter tc = new TurnstileCounter();


    public void runMatch() throws IOException {

        int counter=0;
        int numberOfTurnstile =4;
        List<Turnstile> turnstiles = new ArrayList<>();
        ExecutorService es = Executors.newFixedThreadPool(3);
        ServerSocket serverSocket = new ServerSocket(2345);
        Socket client = serverSocket.accept();
        System.out.println("Wating for Turnstiles ");
        while(counter < numberOfTurnstile){
            Writer out;
            PrintWriter pw = new PrintWriter(client.getOutputStream(),true);
            Scanner sc = new Scanner(client.getInputStream());
            String login = sc.nextLine();
            String[] loginArr = login.split("#");
            if(loginArr[0].equals("TURNSTILE")) {
                String id = loginArr[1];
                Turnstile turnstile = new Turnstile(tc,sc,pw,id);
                turnstiles.add(turnstile);

                es.execute(turnstile);
                counter++;
            }
            if(loginArr[0].equals("MONITOR")) {

            }
            if(loginArr[0].equals("CLOSE")) {
                pw.println("Session is closing");
                client.close();
            }
        }
    }
}
