package com.example.colorfullbuttons;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private GridLayout gridLayout;
    private Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayout = findViewById(R.id.gridLayout);
        Random random = new Random();

        for (int i = 0; i < 17; i++) {
            Button button = new Button(this);
            int color = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            button.setBackgroundColor(color);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.setBackgroundColor(Color.WHITE);
                }
            });
            gridLayout.addView(button);
        }

        resetButton = new Button(this);
        resetButton.setText(R.string.reset);
        resetButton.setBackgroundColor(Color.WHITE);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetButtonsBackground();
            }
        });
        gridLayout.addView(resetButton);
    }

    private void resetButtonsBackground() {
        Random random = new Random();
        int childCount = gridLayout.getChildCount();

        for (int i = 0; i < childCount; i++) {
            View child = gridLayout.getChildAt(i);

            if (child instanceof Button && child != resetButton) {
                int color = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                child.setBackgroundColor(color);
            }
        }
    }
}
