package org.familianascimento.rodrigo.contasdacasa.control;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.familianascimento.rodrigo.contasdacasa.R;
import org.familianascimento.rodrigo.contasdacasa.model.Morador;

import java.text.SimpleDateFormat;

/**
 * {Contas-da-casa}
 * Created by weltonnascimento on 20/05/15.
 */
public class MoradorAdapter extends ArrayAdapter<Morador> {

    LayoutInflater mLayoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");

    private class ViewHolder {
        ImageView image;
        TextView nome;
        TextView ingresso;
        TextView saida;
    }

    public MoradorAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MoradorAdapter.ViewHolder viewHolder;

        if (convertView == null) {

            viewHolder = new MoradorAdapter.ViewHolder();

            convertView = mLayoutInflater.inflate(R.layout.list_morador_item, parent, false);

            viewHolder.image = (ImageView) convertView.findViewById(R.id.morador_image);
            viewHolder.nome = (TextView) convertView.findViewById(R.id.morador_nome);
            viewHolder.ingresso = (TextView) convertView.findViewById(R.id.morador_ingresso);
            viewHolder.saida = (TextView) convertView.findViewById(R.id.morador_saida);

            convertView.setTag(R.layout.list_morador_item, viewHolder);
        } else {
            viewHolder = (MoradorAdapter.ViewHolder) convertView.getTag(R.layout.list_morador_item);
        }

        Morador m = getItem(position);

        //viewHolder.image.setImageDrawable();
        viewHolder.nome.setText(m.nome);
        viewHolder.ingresso.setText(simpleDateFormat.format(m.dataDeIngresso.getTime()));
        viewHolder.saida.setText(simpleDateFormat.format(m.dataDeSaida.getTime()));

        return convertView;
    }
}
