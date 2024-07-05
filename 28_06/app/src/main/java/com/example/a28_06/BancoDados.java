package com.example.a28_06;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BancoDados {

    private final static String TAG = "BancoDados";

    static String KEY_ID = "_id";
    static String KEY_NOME = "nome";
    static String KEY_DIA = "dia";

    String NOME_BANCO = "db_novo";
    String NOME_TABELA = "evento";
    int VERSAO_BANCO = 1;

    String SQL_CREATE_TABLE = "CREATE TABLE " + NOME_TABELA + " (" +
            KEY_ID + " integer PRIMARY KEY autoincrement, " +
            KEY_NOME + " text not null, " +
            KEY_DIA + " text not null);";

    final Context contexto;
    MeuOpenHelper openHelper;
    SQLiteDatabase db;

    public BancoDados (Context ctx) {
        this.contexto = ctx;
        openHelper = new MeuOpenHelper(contexto);
    }

    private class MeuOpenHelper extends SQLiteOpenHelper {

        MeuOpenHelper (Context contexto) {
            super(contexto, NOME_BANCO, null, VERSAO_BANCO);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(SQL_CREATE_TABLE);
            } catch (SQLException e) {
                Log.e(TAG, "Erro na criação do BD");
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + NOME_TABELA);
            onCreate(db);
        }
    }

    public BancoDados abrir() throws SQLException {
        db = openHelper.getWritableDatabase();
        return this;
    }

    public void fechar () {
        openHelper.close();
    }

    public long insereEvento(String nome, String dia) {
        ContentValues campos = new ContentValues();
        campos.put(KEY_NOME, nome);
        campos.put(KEY_DIA, dia);
        return db.insert(NOME_TABELA, null, campos);
    }

    public boolean apagaEvento(long id) {
        return db.delete(NOME_TABELA, KEY_ID + "=" + id, null) > 0;
    }

    public Cursor retornaTodosEventos() {
        String[] camposApresentados = {KEY_ID, KEY_NOME, KEY_DIA};
        return db.query(NOME_TABELA, camposApresentados, null, null, null, null, null);
    }

    public boolean atualizaEvento(long id, String nome, String dia) {
        ContentValues args = new ContentValues();
        args.put(KEY_NOME, nome);
        args.put(KEY_DIA, dia);
        return db.update(NOME_TABELA, args, KEY_ID + "=" + id, null) > 0;
    }
}