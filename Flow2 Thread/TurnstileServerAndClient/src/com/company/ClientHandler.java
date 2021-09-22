package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class ClientHandler implements Runnable {
    Socket client;
    PrintWriter pw;
    Scanner sc;
    TurnstileCounter sharedCounter;
    static Turnstile[] turnStiles;
    boolean isRunning;

    public ClientHandler(Socket client, TurnstileCounter sharedCounter, Turnstile[] turnStiles) throws IOException {
        this.client = client;
        this.pw = new PrintWriter(client.getOutputStream(), true);
        this.sc = new Scanner(client.getInputStream());
        this.sharedCounter = sharedCounter;
        this.turnStiles = turnStiles;
        this.isRunning = true;
    }


    public void protocol() throws IOException, InterruptedException {
        pw.println("You are connected");
        String msg = "";
        while (!msg.equals("END")) {
            msg = sc.nextLine();
            switch (msg.toUpperCase()) {
                case "HELP":
                    pw.println("List of commands:");
                    pw.println("SHOWALL - show all spectators");
                    pw.println("X - adds one spectator");
                    pw.println("X1000 - adds 1000 spectators");
                    pw.println("X100000 - adds 100000 spectators");
                    break;

                case "SHOWALL":
                    pw.println(sharedCounter.getValue());
                    break;

                case "X":
                    getRandomTurnstile().run();
                    pw.println("One spectator have been added");
                    break;

                case "X1000":
                    for (int i = 0; i < 1000; i++) {
                        getRandomTurnstile().run();
                    }
                    pw.println("1000 spectators have been added");
                    break;

                case "X100000":
                    for (int i = 0; i < 100000; i++) {
                        getRandomTurnstile().run();
                    }
                    pw.println("100000 spectators have been added");
                    break;

                case "END":
                    pw.println("Connection is closing");
                    break;

                default:
                    pw.println("Incorrect action");
            }
        }
        client.close();
        isRunning = false;
    }

    public Turnstile getRandomTurnstile() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(turnStiles.length);
        Turnstile turnstile = turnStiles[randomNumber];
        System.out.println("Thread: " + Thread.currentThread().getName() + " Turnstile ID: " +turnstile.getID() + " Amount of spectators: " + sharedCounter.getValue());
        return turnstile;
    }

    public PrintWriter getPw() {
        return pw;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                this.protocol();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
