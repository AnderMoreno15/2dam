package com.example.intentexplicito;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProvinciaActivity extends AppCompatActivity {

    public static final int SECONDARY_ACTIVITY_2 = 2;
    RadioGroup radioGroup = null;
    RadioButton rbGipuzkoa = null;
    RadioButton rbBizkaia = null;
    RadioButton rbAlmeria = null;
    RadioButton rbMurcia = null;
    RadioButton rbJaen = null;
    RadioButton rbAraba = null;

    String noSelection = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_provincia);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        radioGroup = findViewById(R.id.radioGroup);
        rbGipuzkoa = findViewById(R.id.rbGipuzkoa);
        rbBizkaia = findViewById(R.id.rbBizkaia);
        rbAlmeria = findViewById(R.id.rbAlmeria);
        rbMurcia = findViewById(R.id.rbMurcia);
        rbJaen = findViewById(R.id.rbJaen);
        rbAraba = findViewById(R.id.rbAraba);
        Button btnSelectProvincia = findViewById(R.id.btnSelectProvincia);
        btnSelectProvincia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleAction(view);
            }
        });
    }
    public void toggleAction(View v) {
        Intent resultIntent = new Intent();

        if (radioGroup.getCheckedRadioButtonId() == -1) {
            // No hay ningún RadioButton seleccionado, envía un código de error
            resultIntent.putExtra("PARAM_1", "ERROR");
            setResult(RESULT_OK, resultIntent);
        } else {
            RadioButton selectedRadioButton = findViewById(radioGroup.getCheckedRadioButtonId());
            String selectedText = selectedRadioButton.getText().toString();

            resultIntent.putExtra("PARAM_1", selectedText);
            setResult(RESULT_OK, resultIntent);
        }
        finish();
    }

}