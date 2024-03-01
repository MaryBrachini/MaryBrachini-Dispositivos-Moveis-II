package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase bd;
    Cursor registros;
    TextView lblNomeEncontrado;
    TextView lblAnoEncontrado;
    TextView lblCodEncontrado;
    int currentIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        acessaDb();
        lblNomeEncontrado = findViewById(R.id.lblNomeEncontrado);
        lblAnoEncontrado = findViewById(R.id.lblAnoEncontrado);
        lblCodEncontrado = findViewById(R.id.lblCodEncontrado);
    }

    private void acessaDb() {
        try {
            bd = openOrCreateDatabase(
                    "primeiroBanco", MODE_PRIVATE, null);
            bd.execSQL("CREATE TABLE IF NOT EXISTS clientes(" + "codcli int (4), nome varchar (20), anonasc int (4))");
            bd.execSQL("INSERT INTO clientes VALUES (1, 'Carla', 1980)");
            bd.execSQL("INSERT INTO clientes VALUES (2, 'Dimas', 2003)");
            bd.execSQL("INSERT INTO clientes VALUES (3, 'Fuzita', 2009)");
            bd.execSQL("INSERT INTO clientes VALUES (4, 'Hiago', 1950)");
            registros = bd.rawQuery("SELECT * FROM clientes", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void procurarRegistro(View view) {
        EditText valorProcurar = findViewById(R.id.editTextBuscar);
        String procurar = valorProcurar.getText().toString();

        try {
            registros.moveToFirst();
            while (!registros.isAfterLast()) {
                String nome = registros.getString(registros.getColumnIndex("nome"));
                String codigo = registros.getString(registros.getColumnIndex("codcli"));
                String anonasc = registros.getString(registros.getColumnIndex("anonasc"));
                if (nome.equals(procurar)) {
                    lblNomeEncontrado.setText("Nome - " + nome);
                    lblAnoEncontrado.setText("Ano nascimento - " + anonasc);
                    lblCodEncontrado.setText("ID - " + codigo);
                    currentIndex = registros.getPosition();
                    return;
                }
                registros.moveToNext();
            }
            lblNomeEncontrado.setText("Não encontrado");
            lblAnoEncontrado.setText(" ");
            lblCodEncontrado.setText(" ");
            currentIndex = -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void avancar(View view) {
        if (currentIndex != -1 && registros != null && currentIndex < registros.getCount() - 1) {
            registros.moveToPosition(++currentIndex);

            String nome = registros.getString(registros.getColumnIndex("nome"));
            String codigo = registros.getString(registros.getColumnIndex("codcli"));
            String anonasc = registros.getString(registros.getColumnIndex("anonasc"));

            lblNomeEncontrado.setText("Nome: " + nome);
            lblAnoEncontrado.setText("Ano: " + anonasc);
            lblCodEncontrado.setText("ID: " + codigo);
        }
    }

    public void voltar(View view) {
        if (currentIndex != -1 && registros != null && currentIndex > 0) {
            registros.moveToPosition(--currentIndex);

            String nome = registros.getString(registros.getColumnIndex("nome"));
            String codigo = registros.getString(registros.getColumnIndex("codcli"));
            String anonasc = registros.getString(registros.getColumnIndex("anonasc"));

            lblNomeEncontrado.setText("Nome: " + nome);
            lblAnoEncontrado.setText("Ano: " + anonasc);
            lblCodEncontrado.setText("ID:  " + codigo);
        }
    }
}