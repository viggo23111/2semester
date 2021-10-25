package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class Writer extends Thread{
    PrintWriter pw;
    String id;
    boolean keepRunning=true;

    public Writer(PrintWriter pw, String id){
        this.pw=pw;
        this.id=id;
    }

    public void run(){
        pw.println("TURNSTILE#" + id);
        while(keepRunning){
            try {
                Thread.sleep((int)Math.random()*30);
                pw.println(sendNamesToServer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String sendNamesToServer() {
        return "Lars";
    }
}

class Reader extends Thread{
    Scanner sc;
    boolean keepRunning=true;

    public Reader(Scanner sc){
        this.sc=sc;
    }

    public void run(){
        while(keepRunning){
            String msg = sc.nextLine();
            System.out.println("READER " + msg);
        }
    }
}


public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        try {
            main.connect(args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // write your code here
    }

    public void connect(String id) throws IOException {
        Socket socket = new Socket("locahost",2345);
        PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
        Scanner sc = new Scanner(socket.getInputStream());
        Writer writer = new Writer(pw,id);
        Reader reader = new Reader(sc);

    }
}
