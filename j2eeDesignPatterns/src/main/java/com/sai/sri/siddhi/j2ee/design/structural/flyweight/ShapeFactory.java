package com.sai.sri.siddhi.j2ee.design.structural.flyweight;

import java.util.HashMap;

public class ShapeFactory {
    private static final HashMap<String, Shape> cache = new HashMap<>();

    public static Shape getShape(String color) {
        Circle circle = (Circle) cache.get(color);

        if (circle == null) {
            circle = new Circle(color);
            cache.put(color, circle);
            System.out.println("Creating circle of color: " + color);
        }

        return circle;
    }
}
