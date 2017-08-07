package com.sai.sri.siddhi.j2ee.design.structural.proxy;

public class RealImage implements Image {
    String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    @Override
    public void display() {
        System.out.println("displaying image: " + fileName);
    }

    private void loadFromDisk() {
        System.out.println("loading from disk..");
    }
}
