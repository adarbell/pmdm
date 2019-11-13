package com.example.examenpmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    MedioTransporte[] selec = new MedioTransporte[] {};

    MedioTransporte[] electricos = new MedioTransporte[]{
            new MedioTransporte("skate", "Roxi", "12", R.drawable.skate),
            new MedioTransporte("patinete", "Roxi", "15", R.drawable.patinete),
            new MedioTransporte("monociclo", "Oneil", "18", R.drawable.monociclo1)};

    MedioTransporte[] bicis = new MedioTransporte[]{
            new MedioTransporte("Paseo", "Orbea", "15", R.drawable.bici1),
            new MedioTransporte("Ciudad", "Cube", "20", R.drawable.bici2),
            new MedioTransporte("Montaña", "Bike", "25", R.drawable.bici3)};

    MedioTransporte[] coches = new MedioTransporte[]{
            new MedioTransporte("Megane", "Renault", "60", R.drawable.megan1),
            new MedioTransporte("Leon", "Seat", "70", R.drawable.leon3),
            new MedioTransporte("Fiesta", "Ford", "75", R.drawable.fiesta2)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);
        ImageView elec_img = findViewById(R.id.img_11);
        ImageView bicis_img = findViewById(R.id.img_12);
        ImageView coches_img = findViewById(R.id.img_13);
        ImageView img_result = findViewById(R.id.imgResul);

        elec_img.setOnClickListener(v -> {
            img_result.setImageResource(R.drawable.patinete);
            selec = electricos;
        });

        bicis_img.setOnClickListener(v -> {
            img_result.setImageResource(R.drawable.bicis);
            selec = bicis;
        });

        coches_img.setOnClickListener(v -> {
            img_result.setImageResource(R.drawable.coches);
            selec = coches;
        });

        btn.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("vehiculos", selec);

            Intent intent = new Intent(this, Activity2.class);
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }
}
