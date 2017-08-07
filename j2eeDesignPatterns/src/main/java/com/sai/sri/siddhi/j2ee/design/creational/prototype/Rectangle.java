package com.sai.sri.siddhi.j2ee.design.creational.prototype;

public class Rectangle extends Shape {

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle..");
    }
}
