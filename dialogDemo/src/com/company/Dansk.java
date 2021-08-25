package com.company;

public class Dansk extends Dialog{
    @Override
    public String welcome() {
        return "Hej og velkommen";
    }

    @Override
    public String quit() {
        return "tryk q for at stoppe";
    }

    @Override
    public String selectObject() {
        return "Skriv navnet på det objekt du gerne ville undersøge";
    }
}
