package com.example.aula_2203;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btn = (ImageButton)findViewById(R.id.imageBotao);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mostraMensagem();
            }
        });
        EditText et = (EditText)findViewById(R.id.EditTextReuniao);
        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificacao("Clique curto");
            }
        });
    }

   public class mostraMensagem(){
   }

    public class notificacao(){
    }
}
