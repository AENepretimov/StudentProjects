package com.example.delete2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity {

    public static final String MSG_NAME = "msg";
    private ListView lv_video;
    private ArrayList<Video> videoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        lv_video = findViewById(R.id.lv_video);

        videoList = new ArrayList<>();
        videoList.add(new Video(1, "Вводный", "Установка"));
        videoList.add(new Video(2, "Базовый", "Разметка"));
        videoList.add(new Video(3, "Основной", "Контроллер"));


        VideoAdapter videoAdapter = new VideoAdapter(this, R.layout.list_item, videoList);
        lv_video.setAdapter( videoAdapter );

        lv_video.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                intent.putExtra(MSG_NAME, videoList.get(i));
                startActivity(intent);

                Toast.makeText(StartActivity.this, String.valueOf(i) , Toast.LENGTH_SHORT).show();
            }
        });

    }
}