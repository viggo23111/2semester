package com.company;

public class Main {

    public static void main(String[] args) {
	    Even even = new Even();
	    EvenCounter ec1 = new EvenCounter(even);
	    EvenCounter ec2 = new EvenCounter(even);
		try {
	    	ec1.start();
			ec2.start();
			ec1.join();
			ec2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
