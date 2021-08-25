package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        // write your code here

        String s = "hej";
        String s1 = new String("Hej1");

        String s2 = "hej";
        System.out.println("værdien af s er: " + s.hashCode());
        System.out.println("værdien af s2 er: " + s2.hashCode());
        s = "Jeg elsker kage";
        System.out.println("værdien af s er: " + s.hashCode());

        Object o;
        o = "hej med dig";
        System.out.println(o);

        Object[] objects = {new Car(), new Dog(), new Cat()};

        /*for (Object object : objects) {

            if (object instanceof Car){
                ((Car) object).drive();
            }
            if (object instanceof  Dog){
                ((Dog) object).eating();
            }
            if (object instanceof Cat){
                ((Cat) object).meow();
            }
        }

*/
        Command[] commands = {new Car(), new Dog(), new Cat()};
        for (Command command : commands) {
            command.exe();
        }


    }
}
