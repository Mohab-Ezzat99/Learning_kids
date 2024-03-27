package mrandroid.app.util;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {

    private MediaPlayer mediaPlayer;

    public void play(Context context, int resourceId) {
        stop(); // Stop any currently playing audio

        mediaPlayer = MediaPlayer.create(context, resourceId);
        mediaPlayer.start();
    }

    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}