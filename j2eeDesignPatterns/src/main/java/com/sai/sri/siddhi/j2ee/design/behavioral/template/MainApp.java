package com.sai.sri.siddhi.j2ee.design.behavioral.template;

public class MainApp {

    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();

        game = new Football();
        game.play();
    }
}
