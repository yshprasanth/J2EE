package com.sai.sri.siddhi.j2ee.design.creational.abstractfactory;

import com.sai.sri.siddhi.j2ee.design.creational.factory.Circle;
import com.sai.sri.siddhi.j2ee.design.creational.factory.Rectangle;
import com.sai.sri.siddhi.j2ee.design.creational.factory.Shape;
import com.sai.sri.siddhi.j2ee.design.creational.factory.Square;

public class ShapeFactory extends AbstractFactory {

    @Override
    Color getColor(String color) {
        return null;
    }

    @Override
    Shape getShape(String shapeType) {
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
