package com.company;

public class English extends Dialog{

    @Override
    public String welcome() {
        return "Hi and welcome";
    }

    @Override
    public String quit() {
        return "Press q to quit";
    }

    @Override
    public String selectObject() {
        return "Enter the type of object you want to analyse:";
    }

    @Override
    public String getCowName() {
        return "What is the cows name?";
    }

    @Override
    public String getCowAge() {
        return "What is the cows age?";
    }

    @Override
    public String dog() {
        return "dog";
    }

    @Override
    public String cow() {
        return "cow";
    }

    @Override
    public String cowsNameis() {
        return "The cows name is: ";
    }

    @Override
    public String cowsAgeIs() {
        return " and the age is: ";
    }
}
