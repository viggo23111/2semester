package com.company;

import org.w3c.dom.css.Counter;

public class Task1 extends Thread{
    MyCounter myCounter;

    public Task1(MyCounter myCounter){
        this.myCounter = myCounter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000000; i++) {
            myCounter.countUp(i);
        }
    }
}
