package com.example.practica10audiovideo;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class VideoPlayerActivity extends AppCompatActivity {

    public static final int VIDEO_PLAYER_ACTIVITY_1 = 1;
    private MediaController mediaController;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_video_player);

        mediaController = new MediaController(this);

        videoView =findViewById(R.id.videoView);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bunny));
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Toast.makeText(getBaseContext(),"El video esta preparado",Toast.LENGTH_LONG).show();
                mediaController.show(20000);
                videoView.start();
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(getBaseContext(),"El video ha terminado",Toast.LENGTH_LONG).show();
                mediaController.show(20000);
            }
        });
    }
}