package com.example.lib.exercises;

import java.util.Scanner;

public class Exercise10 {
    public static void main(String[] args) {
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size");
        int arraySize = sc.nextInt();

        int array[]= new int[arraySize];

        System.out.println("Enter numbers to array");

        for (int i = 0; i <= array.length-1; i++) {
            array[i]=sc.nextInt();
            sum += array[i];

        }

        System.out.println("Average is "+(double) sum/arraySize);
    }
}
