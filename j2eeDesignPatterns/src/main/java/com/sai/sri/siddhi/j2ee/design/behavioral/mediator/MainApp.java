package com.sai.sri.siddhi.j2ee.design.behavioral.mediator;

public class MainApp {

    public  static void main(String[] args) {
        User john = new User("John");
        User robert = new User("Robert");
        robert.sendMessage("Hi! John !!");
        john.sendMessage("Hi! Robert !!");
    }
}
