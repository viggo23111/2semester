package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static com.company.Main.getInput;

public class ObjectInfo {
    public static void uderskrivAdr(Object o) {
        System.out.println("Udskriver addresse: " + o.hashCode());
    }

    public static Set<String> showAllMethods(Object o) {
        Set<String> stringSet = new TreeSet<>();
        Method[] methods = o.getClass().getMethods();

        for (Method method : methods) {
            stringSet.add(method.getName());
        }
        return stringSet;
    }

    public static Set<String> showMethods(Object o) {
        Set<String> stringSet = new TreeSet<>();
        Method[] methods = o.getClass().getDeclaredMethods();
        for (Method method : methods) {
            stringSet.add(method.getName());
        }
        return stringSet;
    }
    public static Set<String> showMethodsInherited(Object o){
        Set<String> allMethods = showAllMethods(o);
        Set<String> classMethods = showMethods(o);
        allMethods.removeAll(classMethods);
        return allMethods;
    }

    public static void printOutInheritedMethods(Object o){
        Set<String> inheritedMethods = showMethodsInherited(o);
        for (String inheritedMethod : inheritedMethods) {
            System.out.println(inheritedMethod);
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

    public static void printOutFullClasses(Map<String, Object> objectMap){
        Object o1 = objectMap.getOrDefault(getInput("Skriv en klasse"), new Object());
        Class <?> obj = o1.getClass();
        System.out.println(obj.getSimpleName());

        while(true){
            obj = obj.getSuperclass();
            System.out.println(obj.getSimpleName());
            if (obj.getSimpleName().equals("Object")){
                break;
            }
        }
    }
}
