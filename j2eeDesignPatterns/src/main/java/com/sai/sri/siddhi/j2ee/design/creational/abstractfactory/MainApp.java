package com.sai.sri.siddhi.j2ee.design.creational.abstractfactory;

import com.sai.sri.siddhi.j2ee.design.creational.factory.Shape;

public class MainApp {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        shapeFactory = FactoryProducer.getFactory("COLOR");
        Color color1 = shapeFactory.getColor("RED");
        color1.fill();
    }
}
