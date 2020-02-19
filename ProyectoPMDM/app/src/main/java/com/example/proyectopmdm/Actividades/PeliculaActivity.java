package com.example.proyectopmdm.Actividades;

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

import com.example.proyectopmdm.Creacion.ItemPeliculaActivity;
import com.example.proyectopmdm.Pelicula;
import com.example.proyectopmdm.DBHelpers.PeliculaDBHelper;
import com.example.proyectopmdm.R;

import java.util.ArrayList;
import java.util.List;

public class PeliculaActivity extends ListActivity {
    //acciones
    public static final int NEW_ITEM = 1;
    public static final int EDIT_ITEM = 2;
    public static final int SHOW_ITEM = 3;

    //user
    public static int USER_ID = 0;

    //elemento seleccionado
    private int mLastRowSelected = 0;
    public static PeliculaDBHelper mDbHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelicula);

        Bundle bundle = getIntent().getExtras();
        USER_ID = bundle.getInt("userid");

        // abrir la base de datos
        mDbHelper = new PeliculaDBHelper(this);
        try {
            fillData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Button botonIni=(Button)findViewById(R.id.BotonPrincipal);
        botonIni.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent (PeliculaActivity.this, ItemPeliculaActivity.class);
                intent.putExtras(bundle);
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
        //Cursor itemCursor = mDbHelper.getItems();
        Cursor itemCursor = mDbHelper.getItemsFrom(USER_ID);
        Pelicula pelicula = null;
        ArrayList<Pelicula> resultList = new ArrayList<Pelicula>();
        // se procesa el resultado
        while (itemCursor.moveToNext()) {
            int id = itemCursor.getInt(itemCursor.getColumnIndex(PeliculaDBHelper.SL_ID));
            String titulo = itemCursor.getString(itemCursor.getColumnIndex(PeliculaDBHelper.SL_TITULO));
            String autor = itemCursor.getString(itemCursor.getColumnIndex(PeliculaDBHelper.SL_AUTOR));
            String sinopsis = itemCursor.getString(itemCursor.getColumnIndex(PeliculaDBHelper.SL_SINOPSIS));
            int userid = itemCursor.getInt(itemCursor.getColumnIndex(PeliculaDBHelper.SL_USERID));

            pelicula = new Pelicula(id, titulo, autor, sinopsis, userid);
            resultList.add(pelicula);
        }
        //cerramos la base de datos
        itemCursor.close();
        mDbHelper.close();
        //se genera el adaptador
        PeliculaAdapter items = new PeliculaAdapter(this, R.layout.row_list, resultList, getLayoutInflater());
        //asignar adaptador a la lista
        setListAdapter(items);
    }

    private class PeliculaAdapter extends ArrayAdapter<Pelicula> {
        private LayoutInflater mInflater;
        private List<Pelicula> mObjects;

        private PeliculaAdapter(Context context, int resource, List<Pelicula> objects, LayoutInflater mInflater) {
            super(context, resource, objects);
            this.mInflater = mInflater;
            this.mObjects = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Pelicula pelicula = mObjects.get(position);
            // obtención de la vista de la línea de la tabla
            View row = mInflater.inflate(R.layout.row_list, null);
            //rellenamos datos
            TextView titulo = (TextView) row.findViewById(R.id.row_titulo);
            TextView autor = (TextView) row.findViewById(R.id.row_autor);
            titulo.setText(pelicula.getTitulo());
            autor.setText(pelicula.getAutor());
            return row;
        }
    }
}
