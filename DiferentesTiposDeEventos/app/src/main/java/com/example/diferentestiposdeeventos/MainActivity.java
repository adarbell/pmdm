package com.example.diferentestiposdeeventos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context ctx = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx = this;
        Button btn1 = findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(ctx, "Pulsado boton Uno",Toast.LENGTH_SHORT).show();
            }} );
    }

    public void btn2_onClick(View v) {
        Toast.makeText(ctx, "Pulsado boton Dos",Toast.LENGTH_SHORT).show();
    }
}
