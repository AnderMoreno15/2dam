package com.example.primenumbercalculator;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textNumero = null;
    private Button botonComprobar = null;
    private EditText editNumero = null;


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

        botonComprobar = (Button) findViewById(R.id.button);
        botonComprobar.setOnClickListener(this);

        textNumero = (TextView) findViewById(R.id.textView);
        editNumero = (EditText) findViewById(R.id.editTextNumber);
    }
    public void onClick (View v){
        String textoComprobar = getString(R.string.buttonComprobar);
        String textoActual = botonComprobar.getText().toString();
        String textoReiniciar = getString(R.string.buttonReiniciar);

        if(textoActual.equalsIgnoreCase(textoComprobar)){
            int numero = Integer.parseInt(editNumero.getText().toString());
                textNumero.setText(R.string.primo);
                for (int i = 2; i * i <= numero; i += 2) {
                    if (numero % i == 0)
                        textNumero.setText(R.string.noPrimo);
                }
            botonComprobar.setText(textoReiniciar);
        } else if(textoActual.equalsIgnoreCase(textoReiniciar)){
            textNumero.setText(R.string.textIntroduce);
            botonComprobar.setText(textoComprobar);
        }
    }
}