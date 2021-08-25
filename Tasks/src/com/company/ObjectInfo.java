package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ObjectInfo {
    public static void uderskrivAdr(Object o) {
        System.out.println("Udskriver addresse: " + o.hashCode());
    }

    public static Set<String> showAllMethods(Object o) {
        Set<String> stringSet = new TreeSet<>();
        Method[] methods = o.getClass().getMethods();


        for (Method method : methods) {
            stringSet.add(method.getName());
            System.out.println(method.getName());
        }
        return stringSet;
    }

    public static Set<String> showMethods(Object o) {
        Set<String> stringSet = new TreeSet<>();


        Method[] methods = o.getClass().getDeclaredMethods();

        for (Method method : methods) {
            stringSet.add(method.getName());
            System.out.println(method.getName());
        }
        return stringSet;
    }
    public static void showMethodsInherited(Object o){
        Set<String> allMethods = showAllMethods(o);
        Set<String> classMethods = showMethods(o);
        allMethods.removeAll(classMethods);
        System.out.println("Show methods that is inherited!");
        for (String s : allMethods) {
            System.out.println(s);
        }
    }

    public static void showVariables(Object o) {
        System.out.println("Udskriver objektes variables:");
        Field[] fields = o.getClass().getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }

    public static void showSuperClass(Object o) {
        System.out.println(o.getClass().getSimpleName() + "  ------------> " + o.getClass().getSuperclass().getSimpleName());
    }
}
