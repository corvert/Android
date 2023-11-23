package com.example.lib;

public class Retangle implements Shape {

    private double length;
    private  double width;

    public Retangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea(){
        return length*width;
    }

    public double calculatePerimeter(){
        return 2*(length+width);
    }
}
