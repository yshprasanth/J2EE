package com.sai.sri.siddhi.j2ee.design.creational.factory;

public class MainApp {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("Rectangle");
        shape1.draw();

        shape1 = shapeFactory.getShape("Square");
        shape1.draw();

        shape1 = shapeFactory.getShape("Circle");
        shape1.draw();
    }
}
