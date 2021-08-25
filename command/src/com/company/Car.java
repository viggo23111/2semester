package com.company;

public class Car extends Command {

    public void drive(){
        System.out.println("VROM VROM");
    }

    @Override
    public void exe() {
        drive();
    }
}
