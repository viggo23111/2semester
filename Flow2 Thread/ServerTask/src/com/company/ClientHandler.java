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
    Quiz quiz;


    public ClientHandler(Socket client, BlockingQueue<String> messages, Quiz quiz) throws IOException {
        this.client = client;
        this.pw = new PrintWriter(client.getOutputStream(), true);
        this.sc = new Scanner(client.getInputStream());
        this.quiz = quiz;
    }

    public ClientHandler(Socket client, BlockingQueue<String> messages) throws IOException {
        this.client = client;
        this.messages = messages;
        this.pw = new PrintWriter(client.getOutputStream(), true);
        this.sc = new Scanner(client.getInputStream());
    }


    public void protocol() throws IOException, InterruptedException {
        pw.println("Write your name:");
        String username = sc.nextLine();
        User currentUser = new User(username);
        Main.users.add(currentUser);
        pw.println("Hello " + currentUser.getName());


        pw.println("You are connected, send a string to make it uppercase, send 'CLOSE' to stop the connection");
        String msg = "";
        while (!msg.equals("CLOSE")) {
            msg = sc.nextLine();
            String action="";
            String word="";
            if (msg.equals("QUIZ")) {
                action=msg;
            }else{
                String[] split = msg.split("#");
                action = split[0];
                word = split[1];
            }

            switch (action) {
                case "CLOSESESSION":

                    break;
                case "USERS":
                    pw.println("Users online:");
                    printOnlineUsers();

                case "QUIZ":
                    pw.println("Quiz is started");
                    doQuiz();//TODO lav en quiz
                    break;
                case "ALL":
                    messages.put(word);
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
        Main.users.remove(currentUser);
        client.close();
    }

    public void printOnlineUsers(){
        for (int i = 0; i < Main.users.size(); i++) {
            pw.println(Main.users.get(i).getName());
        }
    }

    public void doQuiz() {
        while(!quiz.listEmpty()) {
            pw.println("Write the number on the question you want:");
            Integer key = Integer.valueOf(sc.nextLine());
            String question = quiz.getQuestions(key);
            pw.println(question);
            String answer = sc.nextLine();

            String correctAnswer = quiz.getAnswers(key);
            if (answer.equals(correctAnswer)) {
                pw.println("CORRECT!");
            } else {
                pw.println("WRONG!");
            }
        }
        pw.println("QUIZ is over!");
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
