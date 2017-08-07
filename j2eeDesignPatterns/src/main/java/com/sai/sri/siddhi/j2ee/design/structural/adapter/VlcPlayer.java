package com.sai.sri.siddhi.j2ee.design.structural.adapter;

public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("VlcPlayer - playVlc:" + fileName);
    }

    @Override
    public void playMp4(String fileName) {
    }
}
