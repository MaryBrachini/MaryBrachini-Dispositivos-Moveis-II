package com.example.a28_06;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.List;

public abstract class DisciplinaAdapter extends BaseAdapter {

    private List<Disciplina> disciplinas;
    private LayoutInflater inflater;

    public DisciplinaAdapter (Context contexto, List<Disciplina> disciplinas) {
        this.inflater = (LayoutInflater)
                contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
        this.disciplinas = disciplinas;
    }

    public void novosDados(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return disciplinas.size();
    }

    @Override
    public Object getItem (int position) {
        return disciplinas.get(position);
    }

    @Override
    public View getView (final int position, View convertView,
                         ViewGroup parent) {
        View v = inflater.inflate(R.layout.item_disciplina, null);

        ((TextView)(v.findViewById(R.id.txtNome)))
                .setText(disciplinas.get(position).nome);


        ((ImageButton)(v.findViewById(R.id.btnEditar)))
                .setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            edita(disciplinas.get(position));
                                        }
                                    }
                );


        ImageButton btnExcluir;
        btnExcluir = (ImageButton)(v.findViewById(R.id.btnExcluir));
        HandlerBtnExcluir tratadorBotao = new HandlerBtnExcluir();
        tratadorBotao.position = position;
        btnExcluir.setOnClickListener(tratadorBotao);

        return v;
    }

    class HandlerBtnExcluir implements View.OnClickListener {

        int position;

        @Override
        public void onClick(View v) {
            deleta(disciplinas.get(position));
        }
    }

    @Override
    public long getItemId (int position) {
        return 0;
    }

    public abstract void edita(Disciplina disciplina);
    public abstract void deleta(Disciplina disciplina);
}
