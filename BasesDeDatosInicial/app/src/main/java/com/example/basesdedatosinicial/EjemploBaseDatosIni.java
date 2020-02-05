package com.example.basesdedatosinicial;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class EjemploBaseDatosIni extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_base_datos_ini);

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
                    Toast.makeText(getApplicationContext(),nombreCli + ", " + telefonoCli,Toast.LENGTH_SHORT).show();

       			} while (c.moveToNext());
       		}
            //Cerramos la base de datos
            bd.close();
        } //del if
    }

}
