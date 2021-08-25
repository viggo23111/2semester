package com.company;

public class VovHund extends Command {

    public void hvemErJeg() {
        System.out.println("Jeg er en Vov hund");
    }

    @Override
    public void execute() {
        hvemErJeg();
    }
}
