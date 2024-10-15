package com.example.llamandoawalter;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView imgWalter = null;
    ImageButton btnTlf = null;
    TextView texto = null;
    boolean isActivated = false;

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
        imgWalter = findViewById(R.id.imgWalter);
        texto = findViewById(R.id.textLlamar);
        btnTlf = findViewById(R.id.btnTlf);
        btnTlf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleAction(v);
            }
        });
    }

    public void toggleAction(View v) {
        if (v.getId() == R.id.btnTlf && !isActivated) {
            texto.setText(getString(R.string.llamando));
            btnTlf.setImageResource(R.drawable.colgar);
            imgWalter.setImageResource(R.drawable.walterwhite2);
            isActivated = true;
        } else if (v.getId() == R.id.btnTlf && isActivated) {
            texto.setText(getString(R.string.terminada));
            btnTlf.setImageResource(R.drawable.llamar);
            imgWalter.setImageResource(R.drawable.walterwhite);
            isActivated = false;
        }
    }
}