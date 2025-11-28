package com.example.godamn;

import android.os.Bundle;
import android.widget.ImageView;
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
        ImageView imagemResultado = findViewById(R.id.imagemResultado);

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
            imagemResultado.setImageResource(R.drawable.abaixopeso);

        } else if (imcResultado < 17) {
            campoResultado.setText("Magreza moderada");
            imagemResultado.setImageResource(R.drawable.abaixopeso);

        } else if (imcResultado < 18.5) {
            campoResultado.setText("Magreza leve");
            imagemResultado.setImageResource(R.drawable.abaixopeso);

        } else if (imcResultado < 25) {
            campoResultado.setText("Saudável");
            imagemResultado.setImageResource(R.drawable.normal);

        } else if (imcResultado < 30) {
            campoResultado.setText("Sobrepeso");
            imagemResultado.setImageResource(R.drawable.sobrepeso);

        } else if (imcResultado < 35) {
            campoResultado.setText("Obesidade grau 1");
            imagemResultado.setImageResource(R.drawable.obesidade1);

        } else if (imcResultado < 40) {
            campoResultado.setText("Obesidade grau 2");
            imagemResultado.setImageResource(R.drawable.obesidade2);

        } else {
            campoResultado.setText("Obesidade grau 3");
            imagemResultado.setImageResource(R.drawable.obesidade3);
        }


    }
}