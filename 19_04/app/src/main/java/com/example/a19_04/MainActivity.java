package com.example.a19_04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {
    String[] Disciplinas = {
            "Disciplina 1", "Disciplina 2", "Disciplina 3",
            "Disciplina 4", "Disciplina 5", "Disciplina 6",
            "Disciplina 7",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Botao de Abris as Disciplinas
        abreAdd t1 = new abreAdd();
        t1.setSaida(this);

        Button bt1;
        bt1 = (Button)findViewById(R.id.btnAdd);
        bt1.setOnClickListener(t1);

        //Botao para Abrir os meses
        abreMeses t2 = new abreMeses();
        t2.setSaida(this);

        Button bt2;
        bt2 = (Button)findViewById(R.id.btnMeses);
        bt2.setOnClickListener(t2);

        //Mostrar a Lista de disciplinas
        ArrayAdapter<String> arrayDisciplinas = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, Disciplinas
        );

        ListView listaDisciplina = (ListView)findViewById(R.id.lista);

        listaDisciplina.setAdapter(arrayDisciplinas);
    }

}

//classe para abrir a interface de Adicionar Disciplinas
class abreAdd implements View.OnClickListener {

    private MainActivity saida;

    @Override
    public void onClick(View v) {
        Intent i = new Intent(saida, Adiciona.class);
        saida.startActivity(i);
    }

    public void setSaida(MainActivity p) {
        saida = p;
    }
}

//classe para abrir a interface de ver Meses
class abreMeses implements View.OnClickListener {



    private MainActivity saida;

    @Override
    public void onClick(View v) {
        Intent i = new Intent(saida, Meses.class);
        saida.startActivity(i);
    }

    public void setSaida(MainActivity p2) {
        saida = p2;
    }
}



