package com.example.proyectopmdm.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectopmdm.DBHelpers.LoginDBHelper;
import com.example.proyectopmdm.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = findViewById(R.id.btnLogin);
        EditText userEditText = findViewById(R.id.userEditText);
        EditText pwdEditText = findViewById(R.id.pwdEditText);

        //Login
        btnLogin.setOnClickListener(v -> {
                Login(userEditText.getText(), pwdEditText.getText());
        });
    }

    protected void Login(Editable user, Editable pwd) {
        LoginDBHelper ldbHelper = new LoginDBHelper(this);
        ldbHelper.open();
        if (ldbHelper.login(user.toString(), pwd.toString())) {
            Bundle bundle = new Bundle();
            bundle.putInt("userid", ldbHelper.getUserId(user.toString()));

            Intent intent = new Intent(this, SelectActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(this, "No se pudo autentificar", Toast.LENGTH_SHORT);
            toast.show();
        };
    }
}
