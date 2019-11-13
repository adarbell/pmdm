package com.example.doblelista;

import android.app.Activity;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorLibros {
    Activity context;
    ArrayList<Libro> losLibros;

    public AdaptadorLibros(Activity context, ArrayList<Libro> losLibros) {
        super(context, R.layout.activity_main, losLibros);
        this.context = context;
        this.losLibros = losLibros;
    }

    public View getView(int i, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.activity_main, null);
        TextView lblTitulo = (TextView) item.findViewById(R.id.campoTitulo);
        lblTitulo.setText(losLibros.get(i).getTitulo());
        TextView lblSubtitulo = (TextView) item.findViewById(R.id.campoAutor);
        lblSubtitulo.setText(losLibros.get(i).getAutor());
        ImageView imagen = (ImageView) item.findViewById(R.id.campoImage);

        imagen.setImageResource(losLibros.get(i).getImagen());

        return(item);
    }
}
