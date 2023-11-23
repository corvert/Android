package com.example.lib;

public class Triangle implements Shape {
    double height;
    double base;

    public Triangle(double height, double base) {
        this.height = height;
        this.base = base;
    }


    @Override
    public double calculateArea() {
        return (height*base)/2;
    }

    @Override
    public double calculatePerimeter() {
        return 0;
    }
}
