package com.example.proyectopmdm.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.proyectopmdm.Actividades.JuegoActivity;
import com.example.proyectopmdm.Actividades.LibroActivity;
import com.example.proyectopmdm.Actividades.PeliculaActivity;
import com.example.proyectopmdm.R;

public class SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        Bundle bundle = getIntent().getExtras();

        ImageView imgLibro = findViewById(R.id.img_libro);
        ImageView imgPelicula = findViewById(R.id.img_pelicula);
        ImageView imgJuego = findViewById(R.id.img_juego);

        imgLibro.setOnClickListener(v -> {
            Intent intent = new Intent(this, LibroActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        });
        imgPelicula.setOnClickListener(v -> {
            Intent intent = new Intent(this, PeliculaActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        });
        imgJuego.setOnClickListener(v -> {
            Intent intent = new Intent(this, JuegoActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }
}
