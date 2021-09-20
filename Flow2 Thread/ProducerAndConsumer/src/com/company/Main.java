package com.company;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //1.	A thread (in this case the main thread) must initially fill a shared data structure S1 with numbers from which the corresponding Fibonacci numbers are desired to be calculated.
        //2.	The main thread then starts four Producer threads (P1 - P4) which will all access the shared data structure S1 to retrieve a number, from which it must calculate the corresponding Fibonacci number.
        //3.	When a thread has finished its calculation, the result is placed in another shared data structure S2, and it should fetch a new number to calculate from S1 or stop (leaves its run method) if S1 does not contain any more numbers to be calculated.
        //4.	Immediately after the main thread has started the four Producer threads, it starts a Consumer thread C1, which continuously retrieves the calculated numbers, prints them to the console and calculates the total sum of numbers retrieved (for whatever reason).
        //5.	When all threads have completed, the sum of all the calculated Fibonacci numbers must be printed.
        //
        //Hints:
        //1.	Initialize S1 with the following numbers: 4,5,8,12,21,22,34,35,36,37,42
        //2.	Use a BlockingQueue implementation (ArrayBlockingQueue) for both shared data structures, then this task will be relatively simple (BlockingQueue collections are all Thread Safe)
        //3.	For S1 you can use any of the possible insert methods, but use poll () to remove elements. If this call returns null you know that the list is empty (there are no more numbers to calculate).
        //4.	5. For S2 you should use put() and take() to insert/retrieve elements as they automatically make sure to wait / wake when inserted in a list without more space, or retrieved from a list without elements.
        int[] numbers = {4,5,8,12,21,22,34,35,36,37,42};

        BlockingQueue<Integer> s1 = new ArrayBlockingQueue<>(1024);
      /*  s1.add(4);
        s1.add(5);
        s1.add(8);
        s1.add(12);
        s1.add(21);
        s1.add(22);
        s1.add(34);
        s1.add(35);
        s1.add(36);
        s1.add(37);
        s1.add(42);*/
        BlockingQueue<Integer> s2 = new ArrayBlockingQueue<>(1024);
        Producer p1 = new Producer(s1,s2,numbers);
       // Producer p2 = new Producer(s1);
        //Producer p3 = new Producer(s1);
        //Producer p4 = new Producer(s1);
        //Consumer c1 = new Consumer(s1);
        Thread t1 = new Thread(p1);
        //Thread t2 = new Thread(p2);
        //Thread t3 = new Thread(p3);
        //Thread t4 = new Thread(p4);
        //Thread t5= new Thread(c1);
        t1.start();
        //t2.start();
        //t3.start();
        //t4.start();
        try {
            t1.join();
          //  t2.join();
            //t3.join();
            //t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //   t5.start();

        System.out.println("All items Produced and Consumed");
    }

}
