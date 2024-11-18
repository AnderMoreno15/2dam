package com.example.practica_10_media;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int MAIN_ACTIVITY_1 = 1;

    private MediaPlayer mediaPlayer=new MediaPlayer();

    Button btnAudio, btnVideo;
    TextView tfMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tfMain = findViewById(R.id.tfMain);
        tfMain.setText(R.string.txt_choose_media);

        btnAudio = findViewById(R.id.btnAudio);
        btnAudio.setText(R.string.btn_audio);
        btnAudio.setOnClickListener(this);

        btnVideo = findViewById(R.id.btnVideo);
        btnVideo.setText(R.string.btn_video);
        btnVideo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        if (view == btnAudio){
            intent.setClass(MainActivity.this, AudioPlayerActivity.class);
            startActivity(intent);
        } else if (view == btnVideo) {
            intent.setClass(MainActivity.this, VideoPlayerActivity.class);
            startActivity(intent);
        }
    }


}