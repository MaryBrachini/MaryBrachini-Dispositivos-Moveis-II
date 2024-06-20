package com.example.ativ12_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TelaGato t = new TelaGato();
        t.setSaida(this);

        Button bt;

        bt = (Button)findViewById(R.id.botao);
        bt.setOnClickListener(t);
    }

    class TelaGato implements View.OnClickListener {

        private MainActivity saida;

        @Override
        public void onClick(View v) {
           Intent i = new Intent(saida, Teste.class);
            saida.startActivity(i);
           //Toast.makeText(saida, "ghoghoshghg", Toast.LENGTH_SHORT).show();
        }

        public void setSaida (MainActivity p) {
            saida = p;
        }
    }
}
