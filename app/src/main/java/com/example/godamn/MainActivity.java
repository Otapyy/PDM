package com.example.godamn;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase bd;
    Button btnSalvar;
    ListView listaNomes;
    EditText textoNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnSalvar = findViewById(R.id.btnSalvar);
        listaNomes = findViewById(R.id.lista);
        textoNome = findViewById(R.id.etNome);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        bd = openOrCreateDatabase("meu_banco.db", MODE_PRIVATE, null);
        bd.execSQL("CREATE TABLE IF NOT EXISTS notas" + "(id INTEGER PRIMARY KEY AUTOINCREMENT, titulo VARCHAR, txt TEXT);");

        carregarListagem();

        btnSalvar.setOnClickListener(v -> {
            String titulo = textoNome.getText().toString();
            ContentValues cv = new ContentValues();
            cv.put("titulo", titulo);
            bd.insert("notas",null, cv);
            carregarListagem();

        });

    }

    public void carregarListagem() {
        ArrayList<String> titulos = new ArrayList<String>();
        Cursor cursor = bd.rawQuery("SELECT * FROM notas ORDER BY id DESC", null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()) {
            String titulo = cursor.getString(cursor.getColumnIndex("titulo"));
            titulos.add(titulo);
            cursor.moveToNext();

        }

        ArrayAdapter<String> titulosAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, titulos);

        listaNomes.setAdapter(titulosAdapter);

    }

}