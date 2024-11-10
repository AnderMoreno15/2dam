package com.example.meetbilbaomain;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        ImageButton ibBilbao = findViewById(R.id.IBBilbao);
        ibBilbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear el Intent para abrir la URL
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bilbao.eus"));

                // Intenta iniciar la actividad para abrir el navegador
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    // Muestra un Toast si ocurre un error
                    Toast.makeText(MainActivity.this, "Error al abrir el sitio web", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}