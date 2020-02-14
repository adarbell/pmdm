package com.example.proyectopmdm;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LibroActivity extends ListActivity {
    //acciones
    public static final int NEW_ITEM = 1;
    public static final int EDIT_ITEM = 2;
    public static final int SHOW_ITEM = 3;

    //elemento seleccionado
    private int mLastRowSelected = 0;
    public static LibroDBHelper mDbHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libro);
        // abrir la base de datos
        mDbHelper = new LibroDBHelper(this);
        try {
            fillData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Button botonIni=(Button)findViewById(R.id.BotonPrincipal);
        botonIni.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent (LibroActivity.this,ItemActivity.class);
                startActivityForResult(intent, NEW_ITEM);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        fillData();
    }

    private void fillData() {
        // se abre la base de datos y se obtienen los elementos
        mDbHelper.open();
        Cursor itemCursor = mDbHelper.getItems();
        //Cursor itemCursor = mDbHelper.getItemsFrom(userId);
        Libro libro = null;
        ArrayList<Libro> resultList = new ArrayList<Libro>();
        // se procesa el resultado
        while (itemCursor.moveToNext()) {
            int id = itemCursor.getInt(itemCursor.getColumnIndex(LibroDBHelper.SL_ID));
            String titulo = itemCursor.getString(itemCursor.getColumnIndex(LibroDBHelper.SL_TITULO));
            String autor = itemCursor.getString(itemCursor.getColumnIndex(LibroDBHelper.SL_AUTOR));
            int userid = itemCursor.getInt(itemCursor.getColumnIndex(LibroDBHelper.SL_USERID));

            libro = new Libro(id, titulo, autor, userid);
            resultList.add(libro);
        }
        //cerramos la base de datos
        itemCursor.close();
        mDbHelper.close();
        //se genera el adaptador
        LibroAdapter items = new LibroAdapter(this, R.layout.row_list, resultList, getLayoutInflater());
        //asignar adaptador a la lista
        setListAdapter(items);
    }

    private class LibroAdapter extends ArrayAdapter<Libro> {
        private LayoutInflater mInflater;
        private List<Libro> mObjects;

        private LibroAdapter(Context context, int resource, List<Libro> objects, LayoutInflater mInflater) {
            super(context, resource, objects);
            this.mInflater = mInflater;
            this.mObjects = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Libro libro = mObjects.get(position);
            // obtención de la vista de la línea de la tabla
            View row = mInflater.inflate(R.layout.row_list, null);
            //rellenamos datos
            TextView titulo = (TextView) row.findViewById(R.id.row_titulo);
            TextView autor = (TextView) row.findViewById(R.id.row_autor);
            titulo.setText(libro.getTitulo());
            autor.setText(libro.getAutor());
            return row;
        }
    }
}
