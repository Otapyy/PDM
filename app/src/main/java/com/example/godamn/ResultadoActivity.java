package com.example.godamn;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        TextView campoNomeResultado = findViewById(R.id.campoNomeResultado);
        TextView campoImcResultado = findViewById(R.id.campoImcResultado);
        TextView campoResultado = findViewById(R.id.campoResultadoTexto);

        double intentPeso = getIntent().getDoubleExtra("peso", 1);
        double intentAltura = getIntent().getDoubleExtra("altura", 1);
        String intentNomeResultado = getIntent().getStringExtra("nome");
        double imcResultado = intentPeso / (intentAltura * intentAltura);
        String textImcResultado = "Seu IMC é: " + imcResultado + "!";

        campoNomeResultado.setText(intentNomeResultado);
        campoImcResultado.setText(textImcResultado);

        //nao consegui fazer as imagens a tempo ;((((

        if(imcResultado < 16){
            campoResultado.setText("Magreza grave!");

        } else if (16 <= imcResultado && imcResultado < 17) {
            campoResultado.setText("magreza moderada");

        } else if (17 <= imcResultado && imcResultado < 18.5) {
            campoResultado.setText("magreza leve");

        } else if (18.5 <= imcResultado && imcResultado < 25) {
            campoResultado.setText("saudavel");

        } else if (25 <= imcResultado && imcResultado < 30) {
            campoResultado.setText("sobrepeso");

        } else if (30 <= imcResultado && imcResultado < 35) {
            campoResultado.setText("obesidade grau 1");

        } else if (35 <= imcResultado && imcResultado < 40) {
            campoResultado.setText("obesidade grau 2");

        } else if (imcResultado > 40) {
            campoResultado.setText("obesidade grau 3");

        }


    }
}