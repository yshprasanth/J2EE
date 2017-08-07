package com.sai.sri.siddhi.j2ee.design.creational.singleton;

public enum SingleEnum {
    INSTANCE;

    public void printMessage() {
        System.out.println("printing from single enum ..");
    }
}
