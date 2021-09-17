package com.company;

import org.w3c.dom.css.Counter;

public class Task2 extends Thread{
    MyCounter myCounter;

    public Task2(MyCounter myCounter){
        this.myCounter = myCounter;
    }

    @Override
    public void run() {
        for (int i = 0; i <5; i++) {
            System.out.println(i+1);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
