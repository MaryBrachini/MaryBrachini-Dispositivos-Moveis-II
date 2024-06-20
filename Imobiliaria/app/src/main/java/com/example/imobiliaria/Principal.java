package com.example.imobiliaria;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Principal extends Activity {

    @Override
    public void onCreate (Bundle estado) {
        super.onCreate(estado);
        setContentView(R.layout.layout_principal);

        //Classe que chama o metodo(função) no caso a classe handlerBotao que chama a mensagem
        HandlerBotao trataBotao = new HandlerBotao();

        //Armazena o endereço da tela principal no atributo
        trataBotao.saida = this;

        ImageButton btn = (ImageButton)findViewById(R.id.imagemBotao);

        btn.setOnClickListener(trataBotao);

       /* btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostraMensagem();
            }
        });*/

        EditText et = (EditText)findViewById(R.id.campoRegiao);

        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificacao("Clique curto");
            }
        });

        et.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                notificacao("Clique longo");
                return false;
            }
        });

    }

    //Classe para fazer a conexão em telas
    class HandlerBotao implements View.OnClickListener {

        //Chama a tela principal para poder direcionar ela a proxima tela
        private Principal saida;
        public void setSaida(Principal p){
            saida = p;
        };

        @Override
        //cria o intent que conecta telas para quando clicar ir para a mensagem. Metodo chamar mensagem
        public void onClick(View v) {
            Intent i = new Intent(saida, Mensagem.class);
            //Inicia a tela
            startActivity(i);
        }
    }

    public void notificacao (String texto) {
        Toast.makeText(this, texto, Toast.LENGTH_LONG).show();
    }
}