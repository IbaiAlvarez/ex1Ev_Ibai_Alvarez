package com.example.ex1ev_ibai_alvarez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //Declaramos el elemento que utilizaremos
    ImageView img_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializamos la imagen con el logo
        img_logo = (ImageView) findViewById(R.id.img_logo);

        //ClickListener para pasar a la siguiente activity
        img_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Imagenes_activity.class);
                startActivity(i);            }
        });
    }
}