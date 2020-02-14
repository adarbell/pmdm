package com.example.proyectopmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        ImageView imgLibro = findViewById(R.id.img_libro);
        ImageView imgPelicula = findViewById(R.id.img_pelicula);
        ImageView imgJuego = findViewById(R.id.img_juego);

        imgLibro.setOnClickListener(v -> {
            Intent intent = new Intent(this, LibroActivity.class);
            startActivity(intent);
        });
        imgPelicula.setOnClickListener(v -> {
            Intent intent = new Intent(this, LibroActivity.class);
            startActivity(intent);
        });
        imgJuego.setOnClickListener(v -> {
            Intent intent = new Intent(this, LibroActivity.class);
            startActivity(intent);
        });
    }
}
