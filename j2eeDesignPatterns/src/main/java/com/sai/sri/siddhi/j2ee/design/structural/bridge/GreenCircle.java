package com.sai.sri.siddhi.j2ee.design.structural.bridge;

public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing green cicle: " + radius + ", " + x + ", " + y);
    }
}
