package com.company;

public class EvenCounter extends  Thread {
    private Even even;
    private int sum;

    public EvenCounter(Even even) {
        this.even = even;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            sum+=even.next();
        }
        System.out.println("Got: " +sum);
    }
}
