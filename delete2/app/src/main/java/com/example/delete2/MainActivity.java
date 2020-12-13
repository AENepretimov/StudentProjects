package com.example.delete2;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    MyVideo myVideo;
    SeekBar seekBar;

    private String videoURL;

    private Video video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); // антизасыпалка

        video = (Video) (getIntent().getSerializableExtra(StartActivity.MSG_NAME));

        switch (video.getNumber()){
            case 0:
                videoURL = "https://r3---sn-gvnuxaxjvh-ut5e.googlevideo.com/videoplayback?expire=1607836369&ei=cU7VX5bKJMfr7QSyqLSYCA&ip=178.234.250.85&id=o-AENUfKlqc8kxExN1aKGWS9WHkAHkn8PFC5SPP70pu1wG&itag=22&source=youtube&requiressl=yes&mh=jl&mm=31%2C29&mn=sn-gvnuxaxjvh-ut5e%2Csn-n8v7znlk&ms=au%2Crdu&mv=m&mvi=3&pcm2cms=yes&pl=22&initcwndbps=1295000&vprv=1&mime=video%2Fmp4&ns=PPgaU-Km-klraRmHioPOJ4AF&ratebypass=yes&dur=163.793&lmt=1607289468335004&mt=1607814523&fvip=3&c=WEB&txp=6216222&n=kZqQnaYx__fajMObK&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIgC0ZzRvJvy_sQs-Ag0x4K8CAv4wehoYyyYZUbFeUz3ygCIQCbHNjOF5T2pJJInNqtzRtok_LVhnnZjJMbIAed7kjgbg%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpcm2cms%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIhAIfkQF8Ry6BvH39NqezomCSCDBLyQa8pIbYTuciBrcm6AiA7aTEcMRscVySAkCLyG9MfUWk793SKtydYAhG2cDqpWg%3D%3D";
                break;
        }

        myVideo = findViewById(R.id.videoView);
//        myVideo.setVideoURI(Uri.parse("rtsp://r5---sn-5hne6n7e.googlevideo.com/Cj0LENy73wIaNAmk3cJBg-iaXhMYDSANFC3zIKlcMOCoAUIASARg1-TDn8fs551cigELTndaSktwMkZqakkM/536C324006419F0313CA2AF625794D8123511074.8916013EBD71B85735FE99BBEC10A978B05AA5E9/yt6/1/video.3gp"));
//        myVideo.setMediaController(new MediaController(this));
//        myVideo.requestFocus();
//        myVideo.start();
        myVideo.setUrlAddress(videoURL);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                myVideo.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
//        vidSurface = (SurfaceView) findViewById(R.id.videoView);
//        vidHolder = vidSurface.getHolder();
//        vidHolder.addCallback(this);
    }

}