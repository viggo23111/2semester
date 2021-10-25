package com.company;

public class TurnstileCounter {
    long count = 0;

    public long getValue() {
        return count;
    }

    public synchronized void incr() {
        count++;
    }
}
