package com.example.simplecalculator;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textResultado = null;
    private TextView textError = null;
    private String textoActual = "";

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

        textResultado = (TextView) findViewById(R.id.textResultado);
        textError = (TextView) findViewById(R.id.textError);

        activateButton(R.id.button0);
        activateButton(R.id.button1);
        activateButton(R.id.button2);
        activateButton(R.id.button3);
        activateButton(R.id.button4);
        activateButton(R.id.button5);
        activateButton(R.id.button6);
        activateButton(R.id.button7);
        activateButton(R.id.button8);
        activateButton(R.id.button9);
        activateButton(R.id.buttonSuma);
        activateButton(R.id.buttonResta);
        activateButton(R.id.buttonIgual);
    }

    private void activateButton(int Rid) {
        Button button = findViewById(Rid);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick (View v){
        String button = ((Button)v).getText().toString();

        if (v.getId() == R.id.buttonIgual) {
            textError.setVisibility(View.INVISIBLE);
            textResultado.setVisibility(View.VISIBLE);
            try {
                String result = Operations.doOperation(textoActual);
                textResultado.setText(result);
                textoActual = "";
            } catch (Exception e) {
                textError.setVisibility(View.VISIBLE);
                textResultado.setVisibility(View.INVISIBLE);
            }

        } else if (v.getId() == R.id.buttonSuma && textoActual.isEmpty()) {
            textError.setVisibility(View.VISIBLE);
            textResultado.setVisibility(View.INVISIBLE);

        } else if (v.getId() == R.id.buttonResta && textoActual.isEmpty()) {
            textError.setVisibility(View.VISIBLE);
            textResultado.setVisibility(View.INVISIBLE);

        } else if (v.getId() == R.id.buttonIgual && textoActual.isEmpty()) {
            textError.setVisibility(View.INVISIBLE);
            textResultado.setVisibility(View.VISIBLE);
            textResultado.setText(R.string.btn0);

        } else {
            textError.setVisibility(View.INVISIBLE);
            textResultado.setVisibility(View.VISIBLE);
            textoActual = textoActual + button;
            textResultado.setText(textoActual);
        }
    }
}