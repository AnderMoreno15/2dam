package com.example.buttonandtextview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonOk = null;
    private TextView textActual = null;

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

        botonOk = (Button) findViewById(R.id.button);
        botonOk.setOnClickListener(this);

        textActual = (TextView) findViewById(R.id.textView);
    }

    public void onClick (View v){
        // Texto actual
        String textActualText = textActual.getText().toString();
        // "Pulsa el botón" --> strings.xml
        String textPulsa = getString(R.string.text_pulsa);
        // "Hola mundo" --> strings.xml
        String textHola = getString(R.string.text_hola_mundo);

        if (textActualText.equalsIgnoreCase(textPulsa)){
            textActual.setText(textHola);
        } else {
            textActual.setText(textPulsa);
        }
    }
}