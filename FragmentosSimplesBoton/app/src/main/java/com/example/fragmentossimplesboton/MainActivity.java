package com.example.fragmentossimplesboton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public View mFrg;
    public Button cBtn;
    public CheckBox mChk;
    public int mStackPosition = 1;
    public Random ran = new Random();
    public int coches[] = {R.drawable.coche1, R.drawable.coche2, R.drawable.coche3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFrg=(View)findViewById(R.id.miFrg);
        /* RECUERDA: el fragmento se infla como una vista*/
        mChk=(CheckBox)findViewById(R.id.aparece);
        mChk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(mChk.isChecked())mFrg.setVisibility(View.VISIBLE);
                else mFrg.setVisibility(View.INVISIBLE);
            }
        });

        cBtn=(Button)findViewById(R.id.button);
        cBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment();
            }
        });

        if (savedInstanceState == null) {
            Fragment miFragment = miFragmento.newInstance(coches[0]);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.miFrg, miFragment);
            ft.commit();
        }
        else {
            mStackPosition = savedInstanceState.getInt("position");
        }
    }

    private void addFragment() {
        Fragment miFrag = miFragmento.newInstance(coches[ran.nextInt(coches.length)]);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.miFrg, miFrag);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("position", mStackPosition);
    }
}