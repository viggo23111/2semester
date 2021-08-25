package com.company;

public class MisseKat extends Command {

    public void hvemErJeg() {
        System.out.println("Jeg er en Missekat");
    }

    @Override
    public void execute() {
        hvemErJeg();
    }
}
