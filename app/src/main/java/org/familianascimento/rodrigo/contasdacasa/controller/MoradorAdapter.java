package org.familianascimento.rodrigo.contasdacasa.controller;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.parse.ParseFile;
import com.squareup.picasso.Picasso;

import org.familianascimento.rodrigo.contasdacasa.R;
import org.familianascimento.rodrigo.contasdacasa.model.Morador;
import org.familianascimento.rodrigo.contasdacasa.view.CircularParseImageView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * {Contas da Casa}
 * Created by weltonnascimento on 24/05/15.
 */
public class MoradorAdapter extends ArrayAdapter<Morador> {

    private final String LOG_TAG = "MoradorAdapter";
    LayoutInflater mLayoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");

    private class ViewHolder {
        CircularParseImageView image;
        TextView nome;
        TextView ingressoEEgresso;
    }

    public MoradorAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MoradorAdapter.ViewHolder viewHolder;

        if (convertView == null) {

            viewHolder = new MoradorAdapter.ViewHolder();

            convertView = mLayoutInflater.inflate(R.layout.morador_list_item, parent, false);

            viewHolder.image = (CircularParseImageView) convertView.findViewById(R.id.morador_item_image);
            viewHolder.nome = (TextView) convertView.findViewById(R.id.morador_item_nome);
            viewHolder.ingressoEEgresso = (TextView) convertView.findViewById(R.id.morador_item_datas);

            convertView.setTag(R.layout.morador_list_item, viewHolder);
        } else {
            viewHolder = (MoradorAdapter.ViewHolder) convertView.getTag(R.layout.morador_list_item);
        }

        Morador m = getItem(position);

        viewHolder.nome.setText(m.getNome());

        final Date ingresso = m.getIngresso();
        final Date saida = m.getSaida();
        final ParseFile foto = m.getFoto();

        final String ingressoEEgresso = String.format("%s - %s",
                simpleDateFormat.format(ingresso.getTime()),
                saida != null ? simpleDateFormat.format(saida.getTime()) : ""
        );

        viewHolder.ingressoEEgresso.setText(ingressoEEgresso);

        Log.v(LOG_TAG, "Will picasso this");
        if(foto != null){
            Picasso.with(getContext()).load(foto.getUrl()).resizeDimen(R.dimen.image_width, R.dimen.image_height).centerCrop().into(viewHolder.image);
        }

        convertView.setClickable(false);
        convertView.setFocusable(false);
        convertView.setFocusableInTouchMode(false);
        return convertView;
    }
}