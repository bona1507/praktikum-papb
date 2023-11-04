package com.example.guruji;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MrHeadActivity extends AppCompatActivity {

    private ImageView imageKepala;
    private ImageView imageRambut;
    private ImageView imageAlis;
    private ImageView imageMata;
    private ImageView imageKumis;
    private ImageView imageJambang;
    private ImageView imageKumisB;

    private CheckBox checkBoxKepala;
    private CheckBox checkBoxRambut;
    private CheckBox checkBoxAlis;
    private CheckBox checkBoxMata;
    private CheckBox checkBoxKumis;
    private CheckBox checkBoxJambang;
    private CheckBox checkBoxKumisB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mr_head);

        imageKepala = findViewById(R.id.imageKepala);
        imageRambut = findViewById(R.id.imageRambut);
        imageAlis = findViewById(R.id.imageAlis);
        imageMata = findViewById(R.id.imageMata);
        imageKumis = findViewById(R.id.imageKumis);
        imageJambang = findViewById(R.id.imageJambang);
        imageKumisB = findViewById(R.id.imageKumisB);

        checkBoxKepala = findViewById(R.id.kepala);
        checkBoxRambut = findViewById(R.id.rambut);
        checkBoxAlis = findViewById(R.id.alis);
        checkBoxMata = findViewById(R.id.mata);
        checkBoxKumis = findViewById(R.id.kumis);
        checkBoxJambang = findViewById(R.id.jambang);
        checkBoxKumisB = findViewById(R.id.kumisB);

        // Set OnClickListener for each CheckBox
        checkBoxKepala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleVisibility(imageKepala, checkBoxKepala.isChecked());
            }
        });

        checkBoxRambut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleVisibility(imageRambut, checkBoxRambut.isChecked());
            }
        });

        checkBoxAlis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleVisibility(imageAlis, checkBoxAlis.isChecked());
            }
        });

        checkBoxMata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleVisibility(imageMata, checkBoxMata.isChecked());
            }
        });

        checkBoxKumis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleVisibility(imageKumis, checkBoxKumis.isChecked());
            }
        });

        checkBoxJambang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleVisibility(imageJambang, checkBoxJambang.isChecked());
            }
        });

        checkBoxKumisB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleVisibility(imageKumisB, checkBoxKumisB.isChecked());
            }
        });
    }

    private void toggleVisibility(View view, boolean isVisible) {
        if (isVisible) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.INVISIBLE);
        }
    }
}
