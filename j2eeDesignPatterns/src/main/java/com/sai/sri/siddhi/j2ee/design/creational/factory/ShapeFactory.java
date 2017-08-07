package com.sai.sri.siddhi.j2ee.design.creational.factory;

public class ShapeFactory {

    public Shape getShape(String shapeType) {
        if(shapeType==null) {
            return null;
        }

        if("CIRCLE".equalsIgnoreCase(shapeType)) {
            return new Circle();
        }

        if("RECTANGLE".equalsIgnoreCase(shapeType)) {
            return new Rectangle();
        }

        if("SQUARE".equalsIgnoreCase(shapeType)) {
            return new Square();
        }

        return null;
    }
}
