package com.sai.sri.siddhi.j2ee.design.creational.singleton;

import java.io.Serializable;

public class SerializedSingleObject implements Serializable{

    private static final long serialVersionUID = -121212121L;

    private SerializedSingleObject() {}

    //inner static helper class
    private static class StaticHelper {
        private static final SerializedSingleObject instance = new SerializedSingleObject();
    }

    public static SerializedSingleObject getInstance() {
        return StaticHelper.instance;
    }

    public void printMessage() {
        System.out.println("Serialized single object...");
    }
}
