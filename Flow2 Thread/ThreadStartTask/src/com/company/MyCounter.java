package com.company;

public class MyCounter {
    private int counter;
    String name;

    public MyCounter(String name) {
        this.counter = 0;
        this.name = name;
    }

    public void countUp(){
        this.counter=this.counter+1;
    }

    public int getSum() {
        return counter;
    }
}
