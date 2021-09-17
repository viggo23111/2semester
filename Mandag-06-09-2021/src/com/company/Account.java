package com.company;

public class Account {
    private String name;
    private int balance;

    public Account(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int insert(int i) {
        if (i<0){
            return this.balance;
        }
        this.balance = i+=getBalance();
        return this.balance;
    }

    public int withdraw(int i) {
        if(i>this.balance){
            System.out.println("Not enough money on the account!");
        } else if(i<=0){
            System.out.println("You are unable to withdraw a negative number!");
        } else if (i>50000){
            System.out.println("You are unable to withdraw that amount of money!");
        }
        else{
            this.balance-=this.balance-i;
        }
        return this.balance;


    }
}
