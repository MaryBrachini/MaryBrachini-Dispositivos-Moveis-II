package com.example.h_atv19do04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String[] Disciplinas = {
            "Disciplina 1", "Disciplina 2", "Disciplina 3",
            "Disciplina 4", "Disciplina 5", "Disciplina 6",
            "Disciplina 7",
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> arrayDisciplinas = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, Disciplinas
        );

        ListView listaDisciplina = (ListView)findViewById(R.id.listaDisciplinas);

        listaDisciplina.setAdapter(arrayDisciplinas);
    }
}
