package com.sai.sri.siddhi.j2ee.design.structural.bridge;

public class MainApp {

    public static void main(String[] args) {
        Shape redCircle = new Circle(new RedCircle(),10, 10, 10);
        Shape greenCircle = new Circle(new GreenCircle(), 20, 20, 20);

        redCircle.draw();
        greenCircle.draw();
    }
}
