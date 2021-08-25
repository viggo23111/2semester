package com.company;

public class Dog extends Command{

    public void eating(){
        System.out.println("Dog is eating");
    }

    @Override
    public void exe() {
        eating();
    }
}
