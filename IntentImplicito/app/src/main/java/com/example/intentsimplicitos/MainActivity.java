package com.example.intentsimplicitos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editUrl = null;
    EditText editLat = null;
    EditText editLong = null;
    EditText editMail = null;

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
        TextView tvUrl = findViewById(R.id.tvUrl);
        TextView tvLat = findViewById(R.id.tvLat);
        TextView tvLong = findViewById(R.id.tvLong);
        TextView tvMail = findViewById(R.id.tvMail);

        editUrl = findViewById(R.id.editUrl);
        editLat = findViewById(R.id.editLat);
        editLong = findViewById(R.id.editLong);
        editMail = findViewById(R.id.editMail);

        Button btnWeb = findViewById(R.id.btnUrl);
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnWebAction(v);
            }
        });
        Button btnMapa = findViewById(R.id.btnLat);
        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnMapaAction(v);
            }
        });
        Button btnMail = findViewById(R.id.btnMail);
        btnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnMailAction(v);
            }
        });
    }

    private void btnWebAction(View v) {
        String url = editUrl.getText().toString();
        if (url.isEmpty()){
            Toast.makeText(this, R.string.escribeUrl, Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(Intent.ACTION_VIEW);

            // Para que ponga el http por si no lo pone el cabezon del usuario
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "http://" + url;
            }
            intent.setData(Uri.parse(url));
            startActivity(intent.createChooser(intent, "Escoge una app"));
        }
    }

    private void btnMapaAction(View v) {
        String latitudString = editLat.getText().toString();
        String longitudString = editLong.getText().toString();
        if (latitudString.isEmpty() || longitudString.isEmpty()) {
            Toast.makeText(this, R.string.escribeLatLong, Toast.LENGTH_SHORT).show();
        } else {
            double latitud = Double.parseDouble(latitudString);
            double longitud = Double.parseDouble(longitudString);
            String geoUri = "geo:" + latitud + "," + longitud;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
            startActivity(Intent.createChooser(intent, "Elige una app"));
        }
    }

    private void btnMailAction(View v) {
        String email = editMail.getText().toString();

        if (email.isEmpty()) {
            Toast.makeText(this, R.string.escribeMail, Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
            intent.putExtra(Intent.EXTRA_SUBJECT, "Asunto");
            intent.putExtra(Intent.EXTRA_TEXT, "Mensaje");
            startActivity(Intent.createChooser(intent, "Elige una aplicación de correo"));
        }
    }
}