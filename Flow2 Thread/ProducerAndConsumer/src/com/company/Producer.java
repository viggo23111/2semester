package com.company;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable{
    private final BlockingQueue<Integer> s1;
    private final BlockingQueue<Integer> s2;
    public int[] sTest;
    public int[] sTest2;
    int sum;

    public Producer(BlockingQueue<Integer> s1,BlockingQueue<Integer> s2,int[] sTest) {
        this.s1 = s1;
        this.s2 = s2;
        this.sTest = sTest;
    }


    static int lastID = 0;
    public static void produce( BlockingQueue<String> queue) throws InterruptedException {
        String itemProduced = "Hello"+ lastID++;
        queue.put(itemProduced);
        System.out.println("Produced: "+ itemProduced+ " -- QueueSize: "+queue.size());
    }

    @Override
    public void run() {
        for (int i = 0; i <sTest.length ; i++) {
            System.out.println(sTest[i]);
            int fibNumber=fib(sTest[i]);
            System.out.println(fibNumber);
            sum+=fibNumber;
        }
        System.out.println("Sum: " + sum);
    }

    int fib(int n) {
        if (n < 2) return n;
        return fib(n - 1) + fib(n - 2);
    }

}
