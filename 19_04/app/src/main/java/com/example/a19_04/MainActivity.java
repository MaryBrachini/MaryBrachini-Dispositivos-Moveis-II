package com.example.a19_04;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends Activity {

    private String[] disciplinas = {
            "Disciplina 1", "Disciplina 2", "Disciplina 3",
            "Disciplina 4", "Disciplina 5", "Disciplina 6",
            "Disciplina 7"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> listaDisciplinas = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, disciplinas
        );

        setListAdapter(listaDisciplinas);
    }
}
