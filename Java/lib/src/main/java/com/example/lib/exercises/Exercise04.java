package com.example.lib.exercises;

import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        count(inputString);


    }

    public static void count(String x){
        char[] ch = x.toCharArray();
        int letter = 0, space =0, num= 0, others =0;
        for (int i = 0; i < x.length(); i++) {
            if(Character.isLetter(ch[i])){
                letter++;
            } else if (Character.isDigit(ch[i])) {
                num++;
            } else if (Character.isSpaceChar(ch[i])) {
                space++;
            }else {
                others++;
            }

        }
        System.out.println("Letters " + letter);
        System.out.println("Numbs " + num);
        System.out.println("Spaces " + space);
        System.out.println("Others " + others);

    }
}
