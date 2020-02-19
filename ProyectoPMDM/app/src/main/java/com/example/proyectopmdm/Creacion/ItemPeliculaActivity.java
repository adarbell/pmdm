package com.example.proyectopmdm.Creacion;

import android.app.Activity;
import android.content.Context;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectopmdm.Actividades.PeliculaActivity;
import com.example.proyectopmdm.R;

public class ItemPeliculaActivity extends Activity {
    //referencias a elementos de pantalla
    TextView mTitulo = null;
    TextView mAutor = null;
    TextView mSinopsis  = null;
    String userId = null;
    //identificador de entrada
    Integer mRowId = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_item);
        Bundle bundle = getIntent().getExtras();
        userId = String.valueOf(bundle.getSerializable("userid"));
        Button saveBtn = (Button) findViewById(R.id.add);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setResult(RESULT_OK);
                saveData();
                finish();
            }
        });
        // obtener referencias
        mTitulo = (TextView) findViewById(R.id.titulo);
        mAutor = (TextView) findViewById(R.id.autor);
        mSinopsis  = (TextView) findViewById(R.id.sinopsis);
    }
    protected void saveData() {
        //obtener datos
        String tituloText = mTitulo.getText().toString();
        String autorText = mAutor.getText().toString();
        String sinopsisText = mSinopsis.getText().toString();
        //insertar
        try {
            PeliculaActivity.mDbHelper.open();
            PeliculaActivity.mDbHelper.insertItem(tituloText, autorText, sinopsisText, userId);
            PeliculaActivity.mDbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showMessage(int message){
        Context context = getApplicationContext();
        CharSequence text = getResources().getString(message);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
