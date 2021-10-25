package com.company;

import java.io.PrintWriter;
import java.util.Scanner;

public class Turnstile implements Runnable {
    TurnstileCounter tc;
    Scanner sc;
    PrintWriter pw;
    String name;

    public Turnstile(TurnstileCounter tc, Scanner sc, PrintWriter pw, String id) {
        this.tc = tc;
        this.sc = sc;
        this.pw = pw;
        this.name = "Turnstile_"+id;
    }

    @Override
    public void run() {
        System.out.println("Turnstile "+ name + " is running");
        enterStadion();
    }

    public void enterStadion(){
        while(sc.hasNext()) {
            String spectName=sc.nextLine();
            pw.println("Thanks for entering the match " + spectName);
            tc.incr();
        }
    }
}
