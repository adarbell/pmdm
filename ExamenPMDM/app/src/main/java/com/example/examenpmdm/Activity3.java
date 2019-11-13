package com.example.examenpmdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Bundle bundle = getIntent().getExtras();
        Factura factura = (Factura) bundle.getSerializable("factura");

        ImageView img = findViewById(R.id.imageView);

        TextView text1 = findViewById(R.id.text1);
        TextView text2 = findViewById(R.id.text2);
        TextView text3 = findViewById(R.id.text3);
        TextView text4 = findViewById(R.id.text4);
        TextView text5 = findViewById(R.id.text5);
        TextView text6 = findViewById(R.id.text6);

        img.setImageResource(factura.getImg());
        text1.setText(factura.getModelo());
        text2.setText(String.valueOf(factura.getPrecio_horas()));
        text3.setText(String.valueOf(factura.getExtras()));
        text4.setText(String.valueOf(factura.getnDias()));
        text5.setText(factura.isSeguro() ? "Con Seguro" : "Sin Seguro");
        text6.setText(String.valueOf(factura.getTotal()) + "€");
    }
}
