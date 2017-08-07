package com.sai.sri.siddhi.j2ee.design.creational.singleton;

public class ThreadSafeSingleObject {

    private static ThreadSafeSingleObject instance;

    private ThreadSafeSingleObject() {}

    // Double check locking
    public static ThreadSafeSingleObject getInstance() {
        if(instance == null) {
            synchronized (ThreadSafeSingleObject.class){
                if(instance == null) {
                    instance = new ThreadSafeSingleObject();
                }
            }
        }
        return instance;
    }

    public void printMessage() {
        System.out.println("printing from thread safe single object ..");
    }
}
