package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        /*Task-1 : Should calculate and print the sum of all numbers from 1 to 1 billion (milliard)
Task-2 : Prints the numbers from 1 to 5. Should Pause (sleep) 2 seconds between each output
Task-3 : Prints all numbers from 10 and up. Should pause 3 seconds between each output
The program should stop task-3 after 10 seconds
*/

        MyCounter myCounter1 = new MyCounter("TestCounter");
        Task1 t1 = new Task1(myCounter1);
        t1.setName("Counter1");
        t1.start();
        t1.join();
        System.out.println(myCounter1.getSum());


        MyCounter myCounter2 = new MyCounter("TestCounter");
        Task2 t2 = new Task2(myCounter2);
        t2.setName("Counter1");
        t2.start();
        t2.join();

    }
}
