package com.sai.sri.siddhi.j2ee.design.behavioral.template;

public class Football extends Game{
    @Override
    void initGame() {
        System.out.println("Football init Game");
    }

    @Override
    void startGame() {
        System.out.println("Football start Game");
    }

    @Override
    void endGame() {
        System.out.println("Football end Game");
    }
}
