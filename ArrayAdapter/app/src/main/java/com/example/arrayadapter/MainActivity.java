package com.example.arrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Persona[] personas = new Persona[]{
                new Persona("Antonio","Lopez"),
                new Persona("Jose","Gutierrez"),
                new Persona("Manuel","Rodríguez"),
                new Persona("Francisco","Gimenez"),
                new Persona("David","Danubio")
        };

        ArrayAdapter<Persona> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, personas);
        final Spinner cmbOpciones = findViewById(R.id.CmbOpciones);
        final TextView nombreResult = findViewById(R.id.nombreResult);
        final TextView apellidoResult = findViewById(R.id.apellidoResult);

        cmbOpciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nombreResult.setText(personas[position].getNombre());
                apellidoResult.setText(personas[position].getApellido());
            }
            public void onNothingSelected(AdapterView<?> parent) {
                nombreResult.setText("");
                apellidoResult.setText("");
            }
        });

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbOpciones.setAdapter(adapter);
    }
}
