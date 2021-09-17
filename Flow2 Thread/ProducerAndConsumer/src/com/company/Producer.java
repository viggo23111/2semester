package com.company;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    static int lastID = 0;
    public static void produce( BlockingQueue<String> queue) throws InterruptedException {
        String itemProduced = "Hello"+ lastID++;
        queue.put(itemProduced);
        System.out.println("Produced: "+ itemProduced+ " -- QueueSize: "+queue.size());
    }
    @Override
    public void run() {

        while(true){
            String itemProduced = String.valueOf((int)Math.random()*1000+1000);
            try {
                queue.put(itemProduced);
                System.out.println("Produced: " +itemProduced + " Queue size: " +queue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
