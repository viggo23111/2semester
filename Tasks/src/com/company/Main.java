package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ObjectInfo objectInfo = new ObjectInfo();
        Dialog dialog = new Dansk();
        Object o;
        System.out.println(dialog.welcome());
        Set<String> stringSet = new HashSet<>();
        stringSet = new LinkedHashSet<>();
        stringSet = new TreeSet<>();

        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("MuhKo", new MuhKo("test",10));
        objectMap.put("VovHund", new VovHund());
        objectMap.put("MisseKat", new MisseKat());
        objectMap.put("ObjInfo", new ObjectInfo());
        objectMap.put("Map", new HashMap<>());
        objectMap.put("TreeSet", new TreeSet<>());
        objectMap.put("div0", new ArithmeticException());



        objectInfo.printOutInheritedMethods(objectMap.getOrDefault(getInput("Skriv en type :"),new Object()).getClass().getSimpleName());

        Set<String> strings = objectMap.keySet();
        System.out.println("Her kan du se alle klasserne du kan vælge imellem ");

        for (String string : strings) {
            System.out.println(string);
        }

        while (true) {
            dialog = changeLanguage(dialog,getInput("Select language da/eng to start the program:"));
            System.out.println(dialog.welcome());
            break;
        }

        String svar = getInput(dialog.selectObject());
        if (svar.equals(dialog.dog())){
            o = new VovHund();
            objectInfo.showSuperClass(o);
        }
        else if (svar.equals(dialog.cow())){
            String name = getInput(dialog.getCowName());
            int age = Integer.parseInt(getInput(dialog.getCowAge()));
            o = new MuhKo(name, age);
            System.out.println(dialog.cowsNameis() + name + dialog.cowsAgeIs() + age);
            System.out.println("Superclass:");
            objectInfo.showSuperClass(o);
        }
        else if (svar.equals("String")){
            o = "";
            objectInfo.showSuperClass(o);
        }

       /* switch (svar) {
            case "dog":
            case "hund":
                o = new VovHund();
                break;

            case "cow":
            case "ko":
                String name = getInput(dialog.getCowName());
                int age = Integer.parseInt(getInput(dialog.getCowAge()));
                o = new MuhKo(name, age);
                System.out.println("The cows name is: " + name + " and the age is: " + age);
                System.out.println("Superclass:");
                objectInfo.showSuperClass(o);
                break;

            case "string":
                o = "";
                objectInfo.showSuperClass(o);
                break;
            default: 
                o = new Object();
        }*/
    }

    public static Dialog changeLanguage(Dialog dialog, String language){
        if(language.equals("da")){
            return new Dansk();
        }
        if(language.equals("eng")){
            return new English();
        }
        return dialog;
    }
    public static String getInput(String s) {
        System.out.println(s);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
