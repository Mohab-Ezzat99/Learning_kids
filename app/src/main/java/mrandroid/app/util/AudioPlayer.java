package mrandroid.app.util;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {

    private MediaPlayer mediaPlayer;
    private Runnable onCompletionListener;

    public void play(Context context, int resourceId, Runnable onCompletionListener) {
        stop(); // Stop any currently playing audio

        this.onCompletionListener = onCompletionListener;

        mediaPlayer = MediaPlayer.create(context, resourceId);
        mediaPlayer.setOnCompletionListener(mp -> {
            // Execute code when playback completes
            if (AudioPlayer.this.onCompletionListener != null) {
                AudioPlayer.this.onCompletionListener.run();
            }
        });

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