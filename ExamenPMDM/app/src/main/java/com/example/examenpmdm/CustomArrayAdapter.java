package com.example.examenpmdm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomArrayAdapter extends ArrayAdapter {

    private Context context;
    private MedioTransporte[] vehiculos;

    public CustomArrayAdapter(@NonNull Context context, int resource, @NonNull MedioTransporte[] objects) {
        super(context, resource, objects);
        this.context = context;
        this.vehiculos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if(v == null)
            v = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

        MedioTransporte vehiculo = vehiculos[position];
        TextView tipo = v.findViewById(R.id.spin_tipo);
        TextView modelo = v.findViewById(R.id.spin_modelo);
        TextView precio = v.findViewById(R.id.spin_precio);
        ImageView img = v.findViewById(R.id.spin_img);

        tipo.setText(vehiculo.getTipo());
        modelo.setText(vehiculo.getModelo());
        precio.setText(vehiculo.getPrecio());
        img.setImageResource(vehiculo.getImg());

        return v;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getView(position, convertView, parent);
    }
}