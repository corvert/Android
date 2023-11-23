package com.example.lib.exercises;

import java.util.Scanner;

public class Exercise08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int rows = sc.nextInt();

        int s = rows + 4 - 1;

        for (int i = 1; i <= rows; i++) {//rows

            for (int x = s; x != 0; x--) {//spaces
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) { //Numbers
                System.out.print(i + " ");
            }
            System.out.println();
            s--;
        }
    }
}
