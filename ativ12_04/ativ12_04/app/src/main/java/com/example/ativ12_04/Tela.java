package com.example.ativ12_04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tela extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TelaInicial t  = new Tela.TelaInicial();
        t.setSaida(this);

        Button bt;

        bt = (Button)findViewById(R.id.botaoVoltar);
        bt.setOnClickListener(t);
    }

    class TelaInicial implements View.OnClickListener {

        private Tela saida;

        @Override
        public void onClick(View v) {
            Intent i = new Intent(saida, MainActivity.class);
            saida.startActivity(i);
        }

        public void setSaida (Tela p) {
            saida = p;
        }
    }

}
