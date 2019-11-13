package com.example.doblelista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] genero = {"ciencia", "novela", "teatro"};
    private Libro[][] datos = new Libro[][] {
            {
                new Libro("Ciencia", "Ciencia-T1", "Autor 1", R.drawable.foto1),
                new Libro("Ciencia", "Ciencia-T2", "Autor 2", R.drawable.foto2),
                new Libro("Ciencia", "Ciencia-T3", "Autor 3", R.drawable.foto3)
            },
            {
                new Libro("Novela", "Novela-T1", "Autor 1", R.drawable.foto1),
                new Libro("Novela", "Novela-T2", "Autor 2", R.drawable.foto2),
                new Libro("Novela", "Novela-T3", "Autor 3", R.drawable.foto3)
            },
            {
                new Libro("Teatro", "Teatro-T1", "Autor 1", R.drawable.foto1),
                new Libro("Teatro", "Teatro-T2", "Autor 2", R.drawable.foto2),
                new Libro("Teatro", "Teatro-T3", "Autor 3", R.drawable.foto3)
            }
    };
    ListView lstGenero, lstLibros;
    ArrayAdapter<String> adaptadorGenero;
    AdaptadorLibros adaptador;
    int filaGenero = 0;
    private ArrayList<Libro> elegidos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstGenero = (ListView) findViewById(R.id.libGenero);
        adaptadorGenero = new ArrayAdapter<String>(this, R.layout.simple_list_item_1, genero);
        lstGenero.setAdapter(adaptadorGenero);
        elegidos = new ArrayList<Libro>();
        for (int j = 0; j < 0; j++) {
            elegidos.add(datos[filaGenero][j]);
        }
        lstLibros = (ListView) findViewById(R.id.libLista);
        lstGenero.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mensaje = "Titulo: " + datos[filaGenero][position].getTitulo() + "Subtitulo: " + datos[filaGenero][position].getAutor();
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
            }
        });

    }
}
