package com.example.basesdedatosinicial;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class Lectura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lectura);
        //Abrimos la base de datos en modo escritura
        ClientesSQLiteHelper cliBDh = new ClientesSQLiteHelper(this, "DBClientes", null, 1);

        //Obtenemos referencia a la base de datos para poder modificarla.
        SQLiteDatabase bd = cliBDh.getWritableDatabase();

        //En caso de abrir de forma correcta la base de datos
        if (bd!=null) {
            //Introducimos 3 clientes de ejemplo
            for (int cont=1; cont<=3; cont++) {
                //Creamos los datos
                int codigo = cont;
                String nombre = "Cliente" + cont;
                String telefono = cont + "XXXXXXX";

                //Introducimos los datos en la tabla Clientes
                bd.execSQL("INSERT INTO Clientes (codigo, nombre, telefono) " +
                        "VALUES (" + codigo + ", '" + nombre + "', '" + telefono + "')");
            }
            String[] campos = new String[] {"nombre", "telefono"};
            String[] args4 = new String[] {"cli1"};
            Cursor c = bd.query("Clientes", campos, "nombre=?", args4, null, null, null);
            //Nos aseguramos de que exista al menos un registro
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya mas registros
                do {
                    String nombreCli = c.getString(0);
                    String telefonoCli = c.getString(1);
                } while (c.moveToNext());
            }
            //Cerramos la base de datos
            bd.close();
        } //del if
    }
}
