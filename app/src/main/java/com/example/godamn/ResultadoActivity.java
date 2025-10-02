package com.example.godamn;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultadoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabuada);

        TextView txtTabuada = findViewById(R.id.txtTabuada);
        String numeroStr = getIntent().getStringExtra("numero");
        int num = 0;
        try {
            num = Integer.parseInt(numeroStr);
        } catch (NumberFormatException e) {
            txtTabuada.setText("");
            return;
        }

        StringBuilder tabuada = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            tabuada.append(num).append(" x ").append(i).append(" = ")
                    .append(numero * i).append("\n");
        }
        txtTabuada.setText(tabuada.toString());
    }
}