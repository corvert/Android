package com.example.lib.exercises;

public class Exercise07 {
    public static void main(String[] args) {
        int[] num = {5, 7, 2, 4, 9};
        int odd = 0;
        int even = 0;

        for (int i = 0; i < num.length; i++) {
            if (num[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Odd numbers " + odd);
        System.out.println("Even numbers " + even);
    }
}
