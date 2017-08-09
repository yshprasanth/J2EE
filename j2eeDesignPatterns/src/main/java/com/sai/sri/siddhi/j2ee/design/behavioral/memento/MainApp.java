package com.sai.sri.siddhi.j2ee.design.behavioral.memento;

public class MainApp {
    public  static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("State #1");
        originator.setState("State #2");
        careTaker.add(originator.saveState());

        originator.setState("State #3");
        careTaker.add(originator.saveState());

        originator.setState("State #4");
        System.out.println("Current state: " + originator.getState());

        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }
}
