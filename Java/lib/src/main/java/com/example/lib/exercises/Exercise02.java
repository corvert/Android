package com.example.lib.exercises;

import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius");
        int r = sc.nextInt();
        System.out.println("Area is " + r*r*3.14);
        System.out.println("Perimeter is " + 2*3.14*r);
    }
}
