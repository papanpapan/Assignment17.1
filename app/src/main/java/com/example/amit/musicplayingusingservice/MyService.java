package com.example.amit.musicplayingusingservice;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

import java.io.IOException;

/**
 * Created by Amit on 7/4/2017.
 */

public class MyService extends Service {
    MediaPlayer mediaPlayer=new MediaPlayer();
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //put this song in your device internal sdcard with same name which is mention below and playing it in background.........
        final String Path="sdcard/rabta.mp3";
        Uri uri=Uri.parse(Path);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(getApplicationContext(),uri);
            mediaPlayer.prepare();
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.release();
        mediaPlayer=null;

        super.onDestroy();
    }
}
