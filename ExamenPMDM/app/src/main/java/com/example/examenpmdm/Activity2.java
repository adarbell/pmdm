package com.example.examenpmdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    int imgVehiculo, precioVehiculo, nDias, extras, calculo;
    String modeloVehiculo;
    boolean seguro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Bundle bundle = getIntent().getExtras();
        MedioTransporte[] vehiculos = (MedioTransporte[]) bundle.getSerializable("vehiculos");


        Spinner spinner = findViewById(R.id.spinner);

        spinner.setAdapter(new CustomArrayAdapter(this, R.layout.list_item, vehiculos));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MedioTransporte vehiculo = vehiculos[position];
                imgVehiculo = vehiculo.getImg();
                modeloVehiculo = vehiculo.getModelo();
                precioVehiculo = Integer.valueOf(vehiculo.getPrecio());
                Toast.makeText(Activity2.this, vehiculo.getTipo() + vehiculo.getModelo() + vehiculo.getPrecio() + vehiculo.getImg(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        EditText editText_nDias = findViewById(R.id.editText_nDias);
        TextView preciototal = findViewById(R.id.text_precioTotal);

        CheckBox checkBox = findViewById(R.id.checkBox1);
        CheckBox checkBox2 = findViewById(R.id.checkBox2);
        CheckBox checkBox3 = findViewById(R.id.checkBox3);

        RadioButton btn_seguro1 = findViewById(R.id.btn_seguro1);
        RadioButton btn_seguro2 = findViewById(R.id.btn_seguro2);

        Button btn_totprecio = findViewById(R.id.btn_totprecio);
        btn_totprecio.setOnClickListener(v -> {
            nDias = Integer.valueOf(String.valueOf(editText_nDias.getText()));
            extras = 0;
            seguro = false;
            if (nDias > 0) {
                if (checkBox.isChecked())
                    extras += 50;
                if (checkBox2.isChecked())
                    extras += 50;
                if (checkBox3.isChecked())
                    extras += 50;

                calculo = precioVehiculo * nDias + extras;

                if (btn_seguro2.isChecked())
                    seguro = true;
                    calculo = calculo + (calculo * nDias / 10);

                preciototal.setText(calculo + "€");
            }
        });

        Button btn_factura = findViewById(R.id.btn_factura);
        btn_factura.setOnClickListener(v -> {
            nDias = Integer.valueOf(String.valueOf(editText_nDias.getText()));
            extras = 0;
            seguro = false;
            if (nDias > 0) {
                if (checkBox.isChecked())
                    extras += 50;
                if (checkBox2.isChecked())
                    extras += 50;
                if (checkBox3.isChecked())
                    extras += 50;

                calculo = precioVehiculo * nDias + extras;

                if (btn_seguro2.isChecked())
                    seguro = true;
                calculo = calculo + (calculo * nDias / 10);

                preciototal.setText(calculo + "€");
            }

            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("factura", new Factura(modeloVehiculo, precioVehiculo, extras, nDias, seguro, calculo, imgVehiculo));

            Intent intent = new Intent(this, Activity3.class);
            intent.putExtras(bundle2);
            startActivity(intent);
        });
    }
}
