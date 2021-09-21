package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class ClientHandler implements Runnable {
    Socket client;
    BlockingQueue<String> messages;
    PrintWriter pw;
    Scanner sc;

    public ClientHandler(Socket client) throws IOException {
        this.client = client;
        this.pw = new PrintWriter(client.getOutputStream(), true);
        this.sc = new Scanner(client.getInputStream());
    }

    //TODO LAV NY CONSTRUCTER MED DE DELTE RESSOURCER
    public ClientHandler (Socket client, BlockingQueue<String> messages) throws IOException {
        this.client = client;
        this.messages = messages;
        this.pw = new PrintWriter(client.getOutputStream(), true);
        this.sc = new Scanner(client.getInputStream());
    }


    public void protocol() throws IOException, InterruptedException {
        pw.println("You are connected, send a string to make it uppercase, send 'CLOSE' to stop the connection");
        String msg = "";
        while (!msg.equals("CLOSE")) {
            msg = sc.nextLine();
            //TODO split stengen på '#'
            //TODO: switche på første del og proces anden del data

            String[] split = msg.split("#");
            String action = split[0];
            String word = split[1];

            switch (action) {
                case "ALL":
                    messages.put(word);//TODO indsæt besked i delt ressource
                    break;
                case "UPPER":
                    pw.println(word.toUpperCase());
                    break;
                case "LOWER":
                    pw.println(word.toLowerCase());
                    break;
                case "REVERSE":
                    char[] charArray = word.toCharArray();
                    String outPut = "";
                    for (int i = charArray.length - 1; i > -1; i--) {
                        outPut = outPut + charArray[i];
                    }
                    pw.println(outPut);
                    break;

                default:
                    pw.println("Incorrect action");
            }
        }
        pw.println("Connection is closing");
        client.close();
    }

    public PrintWriter getPw() {
        return pw;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.protocol();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
