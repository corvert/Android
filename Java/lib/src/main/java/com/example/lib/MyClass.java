package com.example.lib;


public class MyClass {

    public static void main(String[] args) {
    Circle circle = new Circle(5);
    Retangle retangle = new Retangle(4, 6);

        System.out.println(circle.calculateArea());
        System.out.println(circle.calculatePerimeter());
        System.out.println(retangle.calculateArea());
        System.out.println(retangle.calculatePerimeter());

    }
}

