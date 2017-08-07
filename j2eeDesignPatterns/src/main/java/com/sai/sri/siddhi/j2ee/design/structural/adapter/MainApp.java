package com.sai.sri.siddhi.j2ee.design.structural.adapter;

public class MainApp {

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "file1.mp3");
        audioPlayer.play("mp4", "file1.mp4");
        audioPlayer.play("vlc", "file1.vlc");
        audioPlayer.play("wma", "file4.wma");


    }
}
