package com.example.godamn;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editNumero = findViewById(R.id.editNumero);
        Button btnGerar = findViewById(R.id.btnGerar);

        btnGerar.setOnClickListener(v -> {
            String numeroStr = editNumero.getText().toString();
            if (!numeroStr.isEmpty()) {
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("numero", numeroStr);
                startActivity(intent);
            }
        });
    }
}