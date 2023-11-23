package com.example.lib.exercises;

import java.util.Scanner;

public class Exercise05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string");
        char[] string = sc.nextLine().toCharArray();

        System.out.println("Reversed string");

        for (int i = string.length-1; i >=0; i--) {
            System.out.print(string[i]);
        }
        System.out.println();
    }
}
