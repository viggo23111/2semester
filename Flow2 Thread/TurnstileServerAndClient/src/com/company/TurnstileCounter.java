package com.company;

public class TurnstileCounter {

    long count = 0;

    public long getValue() {
        return count;
    }

    public void incr() {
        count++;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
