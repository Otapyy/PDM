package com.example.godamn;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            EditText campoNome = findViewById(R.id.campoNome);
            EditText campoPeso = findViewById(R.id.campoPeso);
            EditText campoAltura = findViewById(R.id.campoAltura);

            Button btnDados = findViewById(R.id.btnDados);


            btnDados.setOnClickListener(v ->{

            String dadoTratarNome = campoNome.getText().toString();
            String dadoTratarPeso = campoPeso.getText().toString();
            String dadoTratarAltura = campoAltura.getText().toString();

            double dadoPeso = Double.parseDouble(dadoTratarPeso);
            double dadoAltura = Double.parseDouble(dadoTratarAltura);

            if(!dadoTratarAltura.isEmpty() && !dadoTratarPeso.isEmpty() && !dadoTratarNome.isEmpty()){
                Intent intent = new Intent(this, ResultadoActivity.class);
                intent.putExtra("nome", dadoTratarNome);
                intent.putExtra("peso", dadoPeso);
                intent.putExtra("altura", dadoAltura);
                startActivity(intent);
            }

            });





    }
}