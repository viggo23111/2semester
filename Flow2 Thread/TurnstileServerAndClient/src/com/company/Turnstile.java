package com.company;

import java.util.concurrent.atomic.AtomicInteger;

public class Turnstile implements Runnable{
    private final TurnstileCounter sharedCounter;
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int ID;

    public int getID() {
        return ID;
    }

    Turnstile(TurnstileCounter sharedCounter) {
        this.sharedCounter = sharedCounter;
        ID = count.incrementAndGet();
    }

    @Override
    public void run() {
            this.sharedCounter.incr();
    }
}


