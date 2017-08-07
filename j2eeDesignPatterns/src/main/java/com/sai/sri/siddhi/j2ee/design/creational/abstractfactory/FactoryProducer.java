package com.sai.sri.siddhi.j2ee.design.creational.abstractfactory;

public class FactoryProducer {

    public static AbstractFactory getFactory(String choice) {
        if("SHAPE".equalsIgnoreCase(choice))
            return new ShapeFactory();
        if("COLOR".equalsIgnoreCase(choice))
            return new ColorFactory();

        return null;
    }
}
