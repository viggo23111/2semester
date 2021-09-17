package com.company;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args){
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(15);
        Producer producer = new Producer(queue);
        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(c1);
        Thread t3 = new Thread(c2);
        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All items Produced and Consumed");
    }

}
