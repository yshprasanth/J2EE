package com.sai.sri.siddhi.j2ee.design.creational.abstractfactory;

import com.sai.sri.siddhi.j2ee.design.creational.factory.Shape;

public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shapeType);
}
