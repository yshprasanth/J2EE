package com.sai.sri.siddhi.j2ee.design.structural.adapter;

public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Mp4Player - playMp4: " + fileName);
    }
}
