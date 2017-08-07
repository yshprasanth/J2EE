package com.sai.sri.siddhi.j2ee.design.structural.proxy;

public class MainApp {
    public static void main(String[] args) {
        Image image = new ProxyImage("image.jpg");
        image.display();

        image.display();
    }
}
