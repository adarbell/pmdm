package com.example.holamusica;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    MediaPlayer miMusica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miMusica = MediaPlayer.create(getApplicationContext(), R.raw.desigual);
        final ToggleButton btnBoton = findViewById(R.id.miTogBtn);
        final TextView txtView = findViewById(R.id.miTextView);
        final ImageView imgView = findViewById(R.id.miImageView);
        btnBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnBoton.isChecked()) {
                    miMusica.start();
                    txtView.setText("CANCIÓN registrada por: Desigual");
                    imgView.setVisibility(View.VISIBLE);
                }
                else {
                    miMusica.stop();
                    txtView.setText("");
                    imgView.setVisibility(View.GONE);
                }
            }
        });
    }
}
