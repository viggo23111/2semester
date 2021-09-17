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
        return "Skriv navnet på det objekt du gerne ville undersøge:";
    }

    @Override
    public String getCowName() {
        return "Hvad hedder koen?";
    }

    @Override
    public String getCowAge() {
        return "Hvor gammel er koen ?";
    }

    @Override
    public String dog() {
        return "hund";
    }

    @Override
    public String cow() {
        return "ko";
    }

    @Override
    public String cowsNameis() {
        return "Koens navn er: ";
    }

    @Override
    public String cowsAgeIs() {
        return " og koens alder er: ";
    }
}
