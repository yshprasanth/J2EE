package com.sai.sri.siddhi.j2ee.design.behavioral.template;

public abstract  class Game {
    abstract void initGame();
    abstract void startGame();
    abstract void endGame();

    public void play() {
        initGame();
        startGame();
        endGame();
    }
}
