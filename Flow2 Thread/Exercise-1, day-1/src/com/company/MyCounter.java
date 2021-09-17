package com.company;
public class MyCounter {
    private long counter;
    String name;

    public MyCounter(String name) {
        this.counter = 0;
        this.name = name;
    }

    public void countUp(long number){
        this.counter=this.counter+number;
    }

    public long getSum() {
        return counter;
    }
}