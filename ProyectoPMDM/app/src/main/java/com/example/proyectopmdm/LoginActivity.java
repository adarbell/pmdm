package com.example.proyectopmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = findViewById(R.id.btnLogin);
        EditText userEditText = findViewById(R.id.userEditText);
        EditText pwdEditText = findViewById(R.id.pwdEditText);

        btnLogin.setOnClickListener(v -> {
            //Login
            //Login simulado
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}
