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
        return "Enter the type of object you want to analyse";
    }
}
