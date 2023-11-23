package com.example.lib.exercises;

import java.util.Scanner;

public class Exercise03 {
    public static void main(String[] args) {
        int decNum, quot, i=1, j;
        int binNum[] = new int[100];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Decimal number");
        decNum = sc.nextInt();

        quot = decNum;
        while (quot != 0){
            binNum[i++] = quot%2;
            quot = quot/2;
        }
        System.out.println("Binary number is" );
        for (j=i-1; j>0; j--){
            System.out.println(binNum[j]);
        }
        System.out.println();
    }
}
