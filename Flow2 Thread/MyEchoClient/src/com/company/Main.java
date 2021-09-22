package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class Reader extends Thread{
    boolean keepRunning=true;
    Scanner scFromServer;

    public Reader(Scanner sc){
        scFromServer = sc;
    }
    @Override
    public void run() {
        while(keepRunning){
            System.out.println("READER: " + scFromServer.nextLine());
        }
    }
}

class Writer extends Thread{
    boolean keepRunning=true;
    PrintWriter pwFromServer;
    Scanner sc = new Scanner(System.in);


    public Writer(PrintWriter pw){
        pwFromServer = pw;
    }
    @Override
    public void run() {
        while(keepRunning){
            System.out.println(sc.nextLine());
        }
    }
}



public class Main {


    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.startClient();
    }

    private void startClient() {
        Scanner keyboard = new Scanner(System.in);
        String msg="";
        String fromServer="";
        try {
            Socket socket = new Socket("localhost",2345);
            Scanner sc = new Scanner(socket.getInputStream());
            Reader reader = new Reader(sc);
            reader.start();
            PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
            Writer writer = new Writer(pw);
            while(!msg.equals("CLOSE")){
                msg =  keyboard.nextLine();
                pw.println(msg);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
