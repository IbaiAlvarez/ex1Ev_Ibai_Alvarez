package com.example.ex1ev_ibai_alvarez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Descripcion_Activity extends AppCompatActivity {

    //Declaramos todos los elementos que utilizaremos en esta activity
    TextView lbl_ciudad;
    ImageView img_ciudad;
    TextView lbl_descripcion;
    Button btn_volverAtras;
    Button btn_votarYvolver;
    TextView lbl_votos;

    //Declaramos variables
    int contador_votosBilbao;
    int contador_votosBarcelona;
    int contador_votosMadrid;
    int contador_votosValencia;
    int votos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);

        //Recuperamos los datos del inten que nos envia la activity anterior
        Intent i = getIntent();
        String ciudad =getIntent().getStringExtra("ciudad");
        String descripcion =getIntent().getStringExtra("descripcion");
        votos = getIntent().getIntExtra("votos",0);
        contador_votosBilbao = getIntent().getIntExtra("contadorBilbao",0);
        contador_votosBarcelona = getIntent().getIntExtra("contadorBarcelona",0);
        contador_votosMadrid = getIntent().getIntExtra("contadorMadrid",0);
        contador_votosValencia = getIntent().getIntExtra("contadorValencia",0);

        //Inicializamos nuestros elementos
        lbl_ciudad = findViewById(R.id.lbl_ciudad);
        lbl_descripcion = findViewById(R.id.lbl_descripcion);
        img_ciudad  = (ImageView) findViewById(R.id.img_ciudad);
        btn_volverAtras = findViewById(R.id.btn_volverAtras);
        btn_votarYvolver = findViewById(R.id.btn_votarYvolver);
        lbl_votos = findViewById(R.id.lbl_votos);

        //Llamada a funcion actualizarDatos para actualizar los elementos de la activity con los datos de la ciudad
        actualizarDatos(ciudad,descripcion,votos);

        //ClickListener de volver atras
        btn_volverAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos un nuevo intent y le asignamos parametros
                Intent i = new Intent(Descripcion_Activity.this, Imagenes_activity.class);
                i.putExtra("contadorBilbao",contador_votosBilbao);
                i.putExtra("contadorBarcelona",contador_votosBarcelona);
                i.putExtra("contadorMadrid",contador_votosMadrid);
                i.putExtra("contadorValencia",contador_votosValencia);
                startActivity(i);
            }
        });

        //ClickListener de votar y volver atras
        btn_votarYvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos un nuevo intent y le asignamos parametros
                Intent i = new Intent(Descripcion_Activity.this, Imagenes_activity.class);
                i.putExtra("ciudad",ciudad);
                //Sumamos un voto
                votos = votos+1;
                i.putExtra("votos",votos);
                i.putExtra("contadorBilbao",contador_votosBilbao);
                i.putExtra("contadorBarcelona",contador_votosBarcelona);
                i.putExtra("contadorMadrid",contador_votosMadrid);
                i.putExtra("contadorValencia",contador_votosValencia);
                startActivity(i);
            }
        });
    }

    /**
     * Actualiza los elementos de la activity con los datos seleccionados
     * @param ciudad Ciudad que hemos seleccionado
     * @param descripcion Descripcion de la ciudad que hemos seleccionado
     */
    public void actualizarDatos(String ciudad,String descripcion, int votos){
        //Recoge los recursos para nuestra activity
        Resources res = getResources();

        //Dependiendo de que ciudad se elija selecciona una imagen
        switch (ciudad){
            case "Bilbao":
                img_ciudad.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bilbao));
                break;
            case "Barcelona":
                img_ciudad.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.barcelona));
                break;
            case "Madrid":
                img_ciudad.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.madrid));
                break;
            case "Valencia":
                img_ciudad.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.valencia));
                break;
        }
        lbl_ciudad.setText(ciudad);
        lbl_descripcion.setText(descripcion);
        lbl_votos.setText("Votos: "+votos);
    }
}