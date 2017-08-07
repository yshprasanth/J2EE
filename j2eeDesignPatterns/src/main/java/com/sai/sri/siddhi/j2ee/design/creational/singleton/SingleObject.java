package com.sai.sri.siddhi.j2ee.design.creational.singleton;

public class SingleObject {

    private static SingleObject instance = new SingleObject();

    private SingleObject() {
    }

    public static SingleObject getInstance() {
        return instance;
    }

    public void printMessage() {
        System.out.println("printing from single object ..");
    }
}
