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

import com.example.proyectopmdm.Creacion.ItemJuegoActivity;
import com.example.proyectopmdm.Juego;
import com.example.proyectopmdm.DBHelpers.JuegoDBHelper;
import com.example.proyectopmdm.R;

import java.util.ArrayList;
import java.util.List;

public class JuegoActivity extends ListActivity {
    //acciones
    public static final int NEW_ITEM = 1;
    public static final int EDIT_ITEM = 2;
    public static final int SHOW_ITEM = 3;

    //user
    public static int USER_ID = 0;

    //elemento seleccionado
    private int mLastRowSelected = 0;
    public static JuegoDBHelper mDbHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        Bundle bundle = getIntent().getExtras();
        USER_ID = bundle.getInt("userid");

        // abrir la base de datos
        mDbHelper = new JuegoDBHelper(this);
        try {
            fillData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Button botonIni=(Button)findViewById(R.id.BotonPrincipal);
        botonIni.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent (JuegoActivity.this, ItemJuegoActivity.class);
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
        Juego juego = null;
        ArrayList<Juego> resultList = new ArrayList<Juego>();
        // se procesa el resultado
        while (itemCursor.moveToNext()) {
            int id = itemCursor.getInt(itemCursor.getColumnIndex(JuegoDBHelper.SL_ID));
            String titulo = itemCursor.getString(itemCursor.getColumnIndex(JuegoDBHelper.SL_TITULO));
            String autor = itemCursor.getString(itemCursor.getColumnIndex(JuegoDBHelper.SL_AUTOR));
            String sinopsis = itemCursor.getString(itemCursor.getColumnIndex(JuegoDBHelper.SL_SINOPSIS));
            int userid = itemCursor.getInt(itemCursor.getColumnIndex(JuegoDBHelper.SL_USERID));

            juego = new Juego(id, titulo, autor, sinopsis, userid);
            resultList.add(juego);
        }
        //cerramos la base de datos
        itemCursor.close();
        mDbHelper.close();
        //se genera el adaptador
        JuegoAdapter items = new JuegoAdapter(this, R.layout.row_list, resultList, getLayoutInflater());
        //asignar adaptador a la lista
        setListAdapter(items);
    }

    private class JuegoAdapter extends ArrayAdapter<Juego> {
        private LayoutInflater mInflater;
        private List<Juego> mObjects;

        private JuegoAdapter(Context context, int resource, List<Juego> objects, LayoutInflater mInflater) {
            super(context, resource, objects);
            this.mInflater = mInflater;
            this.mObjects = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Juego juego = mObjects.get(position);
            // obtención de la vista de la línea de la tabla
            View row = mInflater.inflate(R.layout.row_list, null);
            //rellenamos datos
            TextView titulo = (TextView) row.findViewById(R.id.row_titulo);
            TextView autor = (TextView) row.findViewById(R.id.row_autor);
            titulo.setText(juego.getTitulo());
            autor.setText(juego.getAutor());
            return row;
        }
    }
}
