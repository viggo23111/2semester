package com.company;

import org.w3c.dom.css.Counter;

public class CounterThread extends Thread{
    MyCounter myCounter;

    public CounterThread(MyCounter myCounter){
        this.myCounter = myCounter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            myCounter.countUp();
        }
    }
}
