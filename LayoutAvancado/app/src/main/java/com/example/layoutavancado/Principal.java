package com.example.layoutavancado;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

public class Principal extends Activity {

    String[] cores = {
            "Amarelo", "Azul", "Branco", "Lilás",
            "Preto", "Roxo", "Verde", "Vermelho"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_principal);

        //Layout de ujm AutoCompleteTextView
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                cores);

        AutoCompleteTextView at =
                (AutoCompleteTextView)findViewById(R.id.menuOpcoes);
        at.setThreshold(1);
        at.setAdapter(adaptador);

        //Layout de um spinner
        String[] paises = {"Espanha", "Alemanha", "Holanda", "Brasil"};

        Spinner sp = (Spinner)findViewById(R.id.listaSpinner);

        ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, paises);

        sp.setAdapter(adaptador2);

        TrataItemSelec handlerSpinner = new TrataItemSelec();
        handlerSpinner.inicializaAtributos(sp, paises);
        sp.setOnItemSelectedListener(handlerSpinner);
    }

    class TrataItemSelec implements AdapterView.OnItemSelectedListener {

        private Spinner sp;
        private String[] paises;

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            int index = sp.getSelectedItemPosition();

            Toast.makeText(getBaseContext(),
                    paises[index] + " ocupa o " + (index+1) + " no rank",
                    Toast.LENGTH_SHORT
            ).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {}

        public void inicializaAtributos (Spinner sp, String[] paises) {
            this.sp = sp;
            this.paises = paises;
        }
    }
}

