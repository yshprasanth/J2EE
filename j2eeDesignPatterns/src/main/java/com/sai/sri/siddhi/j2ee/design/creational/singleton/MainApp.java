package com.sai.sri.siddhi.j2ee.design.creational.singleton;

public class MainApp {
    public static void main(String[] args) {
        SingleObject object = SingleObject.getInstance();
        object.printMessage();

        SingleEnum.INSTANCE.printMessage();

        SerializedSingleObject singleObject = SerializedSingleObject.getInstance();
        singleObject.printMessage();

        ThreadSafeSingleObject threadSafeSingleObject = ThreadSafeSingleObject.getInstance();
        threadSafeSingleObject.printMessage();
    }
}
