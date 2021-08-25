package com.company;

public class Cat extends Command {

    public void meow(){
        System.out.println("MEOW MEOW");
    }

    @Override
    public void exe() {
        meow();
    }
}
