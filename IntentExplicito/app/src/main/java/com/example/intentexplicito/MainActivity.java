package com.example.intentexplicito;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {

    public static final int SECONDARY_ACTIVITY_1 = 1;
    TextView tvSeleccion = null;

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
        tvSeleccion = findViewById(R.id.tvEleccionVacia);
        Button btnSelect = findViewById(R.id.btnSelectProvincia);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleAction(view);
            }
        });
    }
    public void toggleAction(View v) {
        Intent intent = new Intent(MainActivity.this, ProvinciaActivity.class);
        startActivityForResult(intent, SECONDARY_ACTIVITY_1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SECONDARY_ACTIVITY_1 && resultCode == RESULT_OK) {
            if (data != null && data.hasExtra("PARAM_1")) {
                String selectedRb = data.getStringExtra("PARAM_1");

                if ("ERROR".equals(selectedRb)) {
                    Toast.makeText(this, "Error: No seleccionaste ninguna provincia", Toast.LENGTH_SHORT).show();
                } else {
                    tvSeleccion.setText(getString(R.string.eleccionProvincia) + " " + selectedRb);
                }
            }
        }
    }
}