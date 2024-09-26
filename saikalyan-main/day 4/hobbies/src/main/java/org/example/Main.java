package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the hobbies ");
        String str2;
        ArrayList<String> str = null;
        while (str2 != "stop") {
            String str1;
            str = new ArrayList<>();
            str1 = s.next();
            str.add(str1);
        }
        for (String st : str) {
            System.out.println(str);
        }
    }
}