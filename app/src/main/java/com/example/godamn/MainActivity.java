package com.example.godamn;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> nomes;
    ListView listView;
    Button btnSalvar;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        editText = findViewById(R.id.etNome);
        btnSalvar = findViewById(R.id.btnSalvar);

        nomes = new ArrayList<>(Arrays.asList("Daniel", "Henrique", "Anami"));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                nomes);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(getApplicationContext(), nomes.get(position), Toast.LENGTH_LONG).show();
        });

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            Toast.makeText(getApplicationContext(), nomes.get(position), Toast.LENGTH_LONG).show();
            nomes.remove(position);
            adapter.notifyDataSetChanged();
            return true;
        });

        btnSalvar.setOnClickListener(v -> {
                nomes.add(editText.getText().toString());
                adapter.notifyDataSetChanged();

        });



    }
}
