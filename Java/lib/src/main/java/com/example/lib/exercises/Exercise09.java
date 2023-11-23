package com.example.lib.exercises;

import java.util.Scanner;

public class Exercise09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int rows = sc.nextInt();
        System.out.println("Enter number of Cols");
        int cols = sc.nextInt();

        int matrix1[][]= new int[rows][cols];
        int matrix2[][]= new int[rows][cols];
        int sum[][]= new int[rows][cols];

        System.out.println("Enter elements of first matrix");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter elements of second matrix");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                 sum[i][j] = matrix1[i][j]+matrix2[i][j];
            }
        }
        System.out.println("Sum of matrix");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(sum[i][j]+ "\t");
            }
            System.out.println();
        }
    }
}
