package com.sai.sri.siddhi.j2ee.design.structural.adapter;

public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if("mp3".equalsIgnoreCase(audioType)) {
            System.out.println("MP3, inbuilt type, playing..");
        } else if("vlc".equalsIgnoreCase(audioType) || "mp4".equalsIgnoreCase(audioType)) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media, " + audioType + " format not supported !!");
        }

    }
}
