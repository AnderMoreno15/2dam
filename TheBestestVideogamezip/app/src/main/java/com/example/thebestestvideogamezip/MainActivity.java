package com.example.thebestestvideogamezip;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RadioGroup radioGroup = null;
    RadioButton rbOpt1 = null;
    RadioButton rbOpt2 = null;
    RadioButton rbOpt3 = null;
    RadioButton rbOpt4 = null;
    CheckBox cbTeGusta = null;
    TextView text = null;

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

        radioGroup = findViewById(R.id.radio_group);
        rbOpt1 = findViewById(R.id.rbOpt1);
        rbOpt1.setOnClickListener(this);
        rbOpt2 = findViewById(R.id.rbOpt2);
        rbOpt2.setOnClickListener(this);
        rbOpt3 = findViewById(R.id.rbOpt3);
        rbOpt3.setOnClickListener(this);
        rbOpt4 = findViewById(R.id.rbOpt4);
        rbOpt4.setOnClickListener(this);
        cbTeGusta = findViewById(R.id.cbTeGusta);
        cbTeGusta.setOnClickListener(this);
        text = findViewById(R.id.textAVer);

    }
    public void onClick(View v) {
        if (v.getId() == R.id.cbTeGusta) {
            if (cbTeGusta.isChecked()) {
                text.setText(getString(R.string.teMola));
            } else {
                text.setText(getString(R.string.noTeMola));
            }
        } else {
            RadioButton selectedButton = findViewById(v.getId());
            String textButton = selectedButton.getText().toString();
            text.setText(getString(R.string.veoQue) + " " + textButton);
        }
    }
}