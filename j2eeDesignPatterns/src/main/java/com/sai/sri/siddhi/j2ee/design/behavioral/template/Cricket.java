package com.sai.sri.siddhi.j2ee.design.behavioral.template;

public class Cricket extends Game {
    @Override
    void initGame() {
        System.out.println("Cricket init Game");
    }

    @Override
    void startGame() {
        System.out.println("Cricket start Game");
    }

    @Override
    void endGame() {
        System.out.println("Cricket end Game");
    }
}
