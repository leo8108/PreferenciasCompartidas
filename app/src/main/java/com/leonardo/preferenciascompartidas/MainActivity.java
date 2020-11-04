package com.leonardo.preferenciascompartidas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button botonNegro, botonRojo, botonAzul, botonVerde, botonCuenta, botonResta;
    TextView txt1;
    private int contador=0;
    private int color;
    private  SharedPreferences mPreferences;
    private  String sharedPrefFile ="LLAVE";
    private String rescateContador = "MANTENIENDO_CONTADOR";
    private String rescateColor = "MANTENIENDO_COLOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonNegro = findViewById(R.id.button);
        botonRojo = findViewById(R.id.button2);
        botonAzul = findViewById(R.id.button3);
        botonVerde = findViewById(R.id.button4);
        botonCuenta = findViewById(R.id.button5);
        botonResta = findViewById(R.id.button6);
        txt1 = findViewById(R.id.textView);
        txt1.setText(""+contador);
        botonNegro.setBackgroundColor(Color.BLACK);
        botonRojo.setBackgroundColor(Color.RED);
        botonAzul.setBackgroundColor(Color.BLUE);
        botonVerde.setBackgroundColor(Color.GREEN);



        mPreferences = getSharedPreferences(sharedPrefFile,MODE_PRIVATE);
        contador = mPreferences.getInt(rescateContador,0);
        txt1.setText(String.format("%s",contador));
        color = mPreferences.getInt(rescateColor,Color.WHITE);
        txt1.setBackgroundColor(color);

        botonCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                txt1.setText(""+contador);

            }
        });

        botonResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador--;
                txt1.setText(""+contador);
            }
        });

        botonNegro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setBackgroundColor(Color.BLACK);
                color = Color.BLACK;
            }
        });


        botonRojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setBackgroundColor(Color.RED);
                color = Color.RED;
            }
        });

        botonAzul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setBackgroundColor(Color.BLUE);
                color = Color.BLUE;
            }
        });

        botonVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setBackgroundColor(Color.GREEN);
                color = Color.GREEN;
            }
        });

    }
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor preferencesEditor= mPreferences.edit();
        preferencesEditor.putInt(rescateContador,contador);
        preferencesEditor.putInt(rescateColor,color);
        preferencesEditor.apply();

    }
}