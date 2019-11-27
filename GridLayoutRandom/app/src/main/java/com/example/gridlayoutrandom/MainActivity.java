package com.example.gridlayoutrandom;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import static com.example.gridlayoutrandom.RandomUtils.randomInt;

public class MainActivity extends AppCompatActivity {

    ImageView[][] imagenes = new ImageView[3][3];
    int[] drawables = {R.drawable.bici1, R.drawable.bici2, R.drawable.bici3,
            R.drawable.megan1, R.drawable.fiesta2, R.drawable.leon3,
            R.drawable.monociclo1, R.drawable.monociclo2, R.drawable.skate};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout l = (GridLayout) findViewById(R.id.gridLayout);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do what you want
            }
        };

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                imagenes[i][j] = new ImageView(this);
                imagenes[i][j].setImageResource(drawables[randomInt(9)]);
                imagenes[i][j].setOnClickListener(clickListener);
                l.addView(imagenes[i][j]);
            }
        }
    }
}
