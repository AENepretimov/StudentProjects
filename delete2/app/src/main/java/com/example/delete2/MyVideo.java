package com.example.delete2;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.NonNull;

public class MyVideo extends SurfaceView implements SurfaceHolder.Callback, MediaPlayer.OnPreparedListener {
    String urlAddress;    private final MediaPlayer mediaPlayer = new MediaPlayer();
    private SurfaceHolder vidHolder;

    boolean isStart;
    final int SECOND = 1000;

    public MyVideo(Context context) {
        super(context);
        initHolder();
    }

    public MyVideo(Context context, AttributeSet attrs) {
        super(context, attrs);
        initHolder();
    }

    public MyVideo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initHolder();
    }

    public MyVideo(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initHolder();
    }

    private void initHolder() {
        vidHolder = this.getHolder();
        vidHolder.addCallback(this);
        this.setOnClickListener(clickListener());
    }

    private View.OnClickListener clickListener() {
        return new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStart)
                    pause();
                else
                    start();
                isStart = !isStart;
            }
        };
    }


    public void setUrlAddress(String urlAddress) {
        this.urlAddress = urlAddress;
    }

    private void start() {
        mediaPlayer.start();
    }

    public void stop() {
        mediaPlayer.stop();
    }

    private void pause() {
        mediaPlayer.pause();
    }

    public void restart() {
        mediaPlayer.reset();
        this.invalidate();
    }

    public void seekTo(int progress){
        mediaPlayer.seekTo((int) (progress/100.0*mediaPlayer.getDuration()));
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {

        if (!TextUtils.isEmpty(urlAddress)) {
            try {
                mediaPlayer.setOnPreparedListener(this);
                mediaPlayer.setDisplay(vidHolder);
                mediaPlayer.setDataSource(urlAddress);

                mediaPlayer.prepare();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }

    @Override
    public void onPrepared(MediaPlayer mp) {

        mediaPlayer.seekTo(1);
//        state = State.Prepared;
//        if (isStart){
//            mediaPlayer.start();
//            state = State.Started;
//        }
    }
}
