package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        MyCounter myCounter = new MyCounter("TestCounter");
        CounterThread t1 = new CounterThread(myCounter);
        CounterThread t2 = new CounterThread(myCounter);
        t1.setName("Counter1");
        t2.setName("Counter2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(myCounter.getSum());



      /*  Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("I'm counting " +i+ " "+Thread.currentThread().getName());

                }
            }
        };
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Number " + (i+1));
                }
            }
        };
        Thread t1= new Thread(r);
        t1.setName("test1");
        Thread t2= new Thread(r2);
        t2.setName("test2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Done");*/


    }


}
