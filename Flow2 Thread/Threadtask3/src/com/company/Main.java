package com.company;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class WorkerCancelable implements Runnable{
    boolean keepRunning = true;
    Thread thread;
    public void run() {
        thread = Thread.currentThread();

        while(keepRunning){
            System.out.println(thread.getName()+" Hello ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
                cancel();
            }
        }
    }
    public void cancel() {
        keepRunning = false;
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException {
        WorkerCancelable worker = new WorkerCancelable();
        WorkerCancelable worker2 = new WorkerCancelable();
        WorkerCancelable worker3 = new WorkerCancelable();
        WorkerCancelable worker4 = new WorkerCancelable();

        /*Thread t = new Thread(worker);
        Thread t2 = new Thread(worker);
        Thread t3 = new Thread(worker);
        Thread t4 = new Thread(worker);
        Thread t5 = new Thread(worker);*/
        ExecutorService es = Executors.newFixedThreadPool(4);

        es.execute(worker);
        es.execute(worker2);
        es.execute(worker3);
        es.execute(worker4);

        es.awaitTermination(5000, TimeUnit.MILLISECONDS);
        es.shutdownNow();
        System.out.println("DONE");
    }
}

