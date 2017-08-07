package com.sai.sri.siddhi.j2ee.design.structural.adapter;

public class MediaAdapter implements MediaPlayer {

    private AdvancedMediaPlayer mediaPlayer;

    public MediaAdapter(String audioType) {
        if("VLC".equalsIgnoreCase(audioType))
            mediaPlayer = new VlcPlayer();
        else if("MP4".equalsIgnoreCase(audioType))
            mediaPlayer = new Mp4Player();
    }

    @Override
    public void play(String audioType, String fileName) {
        if("VLC".equalsIgnoreCase(audioType))
            mediaPlayer.playVlc(fileName);
        else if("MP4".equalsIgnoreCase(audioType))
            mediaPlayer.playMp4(fileName);
    }
}
