package com.sai.sri.siddhi.j2ee.design.creational.prototype;

public class Square extends Shape {

    public Square() {
        type = "Square";
    }

    @Override
    void draw() {
        System.out.println("Inside Square..");
    }

}
