package com.example.lib.exercises;

public class Exercise06 {
    public static void main(String[] args) {
        int[] array1 = {1, 3, -5, 4};
        int[] array2 = {1,4,-5,2};
        String result = "";

        for (int i = 0; i < array1.length; i++) {
           int num1 = array1[i];
           int num2 = array2[i];
           result += (num1*num2)+ " ";
        }
        System.out.println("result " + result);
    }
}
