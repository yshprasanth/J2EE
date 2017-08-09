package com.sai.sri.siddhi.j2ee.design.behavioral.observer;

public abstract class Observer {
    protected Subject subject;

    public abstract void update();
}
