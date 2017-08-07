package com.sai.sri.siddhi.j2ee.design.creational.abstractfactory;

import com.sai.sri.siddhi.j2ee.design.creational.factory.Shape;

public class ColorFactory extends AbstractFactory {
    @Override
    Color getColor(String color) {
        if(color==null) {
            return null;
        }

        if("RED".equalsIgnoreCase(color)) {
            return new Red();
        }

        if("BLUE".equalsIgnoreCase(color)) {
            return new Blue();
        }

        if("GREEN".equalsIgnoreCase(color)) {
            return new Green();
        }

        return null;
    }

    @Override
    Shape getShape(String shapeType) {
        return null;
    }
}
