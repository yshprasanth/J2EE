package com.sai.sri.siddhi.j2ee.design.creational.prototype;

public class MainApp {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clonedShape = (Shape) ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType() + ", hash: " + clonedShape.hashCode());

        clonedShape = (Shape) ShapeCache.getShape("1");
        System.out.println("Another Shape : " + clonedShape.getType() + ", hash: " + clonedShape.hashCode());

        Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());

        Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());
    }
}

