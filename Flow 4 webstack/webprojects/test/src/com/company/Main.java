package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] arr={"Test1", "test2", "test3", "test4", "test5"};
        Random r=new Random();
        String randomString=r.next(arr.length);
        System.out.println(arr[randomNumber]);


            //String array
            String[] strings = {"Hello", "my", "name", "is", "World", "and", "I", "love", "Java", "Language"};

            System.out.print("Give your number of Test Cases: ");
            //Get user input

            for(int i = 0; i < strings.length; i++){
                int index = (int)(Math.random() * 10);
                System.out.println(strings[index]);
            }
        }
    }

}
