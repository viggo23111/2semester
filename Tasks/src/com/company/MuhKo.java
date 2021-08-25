package com.company;

public class MuhKo extends Command {

    public String name;
    public int age;

    public MuhKo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void hvemErJeg() {
        System.out.println("Jeg er en Muh ko");
    }

    @Override
    public void execute() {
        hvemErJeg();
    }
}
