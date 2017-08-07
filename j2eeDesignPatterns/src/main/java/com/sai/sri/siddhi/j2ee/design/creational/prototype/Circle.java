package com.sai.sri.siddhi.j2ee.design.creational.prototype;

public class Circle extends Shape {
    public Circle() {
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("Inside Circle..");
    }

}
