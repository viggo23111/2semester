package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String s = "Hej";
        Person person = new Person();
        //MuhKo muhKo = new MuhKo();
        VovHund vovHund = new VovHund();
        MisseKat misseKat = new MisseKat();
        ObjectInfo objectInfo = new ObjectInfo();

        objectInfo.printOutInheritedMethods(objectInfo);
/*
        Command[] commands = new Command[5];
        commands[0] = new MuhKo("Cow1", 10);
        commands[1] = new VovHund();
        commands[2] = new MisseKat();
        commands[3] = new MuhKo("Cow2", 20);
        commands[4] = new VovHund();


        for (Command command : commands) {
            command.execute();
        }
        ArrayList<Command> commandArraylist = new ArrayList<>(Arrays.asList(commands));
        System.out.println("Arraylist ");
        for (Command command : commandArraylist) {
            command.execute();
        }

        objectInfo.showMethods(new MuhKo("Cow3", 30));
        objectInfo.showVariables(new MuhKo("COWTEST", 18));
        objectInfo.showSuperClass(vovHund);
        System.out.println("Du skrev: " + getInput("Skriv noget"));
        String svar = getInput("Hvilken type objekt vil du have?");
        Object o;

        switch (svar) {
            case "hund":
                o = new VovHund();
                break;

            case "ko":
                String name = getInput("Hvad hedder koen?");
                int age = Integer.parseInt(getInput("Hvor gammel er koen?"));
                o = new MuhKo(name, age);
                objectInfo.showSuperClass(o);
                break;

            case "string":
                o = "";
                objectInfo.showSuperClass(o);
                break;
            default:
                o = new Object();

        }

 */
    }





    public static String getInput(String s) {
        System.out.println(s);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
