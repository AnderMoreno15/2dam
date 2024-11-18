package com.example.practica10audiovideo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int MAIN_ACTIVITY_1 = 1;

    private MediaPlayer mediaPlayer = new MediaPlayer();

    Button btnAudio, btnVideo;
    TextView tvElige;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvElige = findViewById(R.id.TVElige);
        tvElige.setText(R.string.elige);

        btnAudio = findViewById(R.id.btnAudio);
        btnAudio.setText(R.string.audio);
        btnAudio.setOnClickListener(this);

        btnVideo = findViewById(R.id.btnVideo);
        btnVideo.setText(R.string.video);
        btnVideo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        if (view == btnAudio){
            intent.setClass(MainActivity.this, AudioActivity.class);
            startActivity(intent);
        } else if (view == btnVideo) {
            intent.setClass(MainActivity.this, VideoActivity.class);
            startActivity(intent);
        }
    }
}