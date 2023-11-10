package com.example.ex1ev_ibai_alvarez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Imagenes_activity extends AppCompatActivity {

    //Declaracion de elementos del activity
    Button btn_bilbao;
    Button btn_barcelona;
    Button btn_madrid;
    Button btn_valencia;
    TextView lbl_votosBilbao;
    TextView lbl_votosBarcelona;
    TextView lbl_votosMadrid;
    TextView lbl_votosValencia;

    //Declaracion de variables de activity
    int contador_votosBilbao;
    int contador_votosBarcelona;
    int contador_votosMadrid;
    int contador_votosValencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagenes);

        //Inicializamos los elementos del activity
        lbl_votosBilbao = findViewById(R.id.lbl_votosBilbao);
        lbl_votosBarcelona = findViewById(R.id.lbl_votosBarcelona);
        lbl_votosMadrid = findViewById(R.id.lbl_votosMadrid);
        lbl_votosValencia = findViewById(R.id.lbl_votosValencia);

        btn_bilbao = findViewById(R.id.btn_bilbao);
        btn_barcelona = findViewById(R.id.btn_barcelona);
        btn_madrid = findViewById(R.id.btn_madrid);
        btn_valencia = findViewById(R.id.btn_valencia);

        //Llamada a la funcion actualizarVotos
        actualizarVotos();

        //ClickListener para boton Bilbao
        btn_bilbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos un nuevo intent y le asignamos parametros
                Intent i = new Intent(Imagenes_activity.this,Descripcion_Activity.class);

                i.putExtra("ciudad",getString(R.string.bilbao));
                i.putExtra("descripcion",getString(R.string.des_bilbao));
                i.putExtra("votos",contador_votosBilbao);
                i.putExtra("contadorBilbao",contador_votosBilbao);
                i.putExtra("contadorBarcelona",contador_votosBarcelona);
                i.putExtra("contadorMadrid",contador_votosMadrid);
                i.putExtra("contadorValencia",contador_votosValencia);
                startActivity(i);
            }
        });

        //ClickListener para boton Barcelona
        btn_barcelona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos un nuevo intent y le asignamos parametros
                Intent i = new Intent(Imagenes_activity.this,Descripcion_Activity.class);

                i.putExtra("ciudad",getString(R.string.barcelona));
                i.putExtra("descripcion",getString(R.string.des_barcelona));
                i.putExtra("votos",contador_votosBarcelona);
                i.putExtra("contadorBilbao",contador_votosBilbao);
                i.putExtra("contadorBarcelona",contador_votosBarcelona);
                i.putExtra("contadorMadrid",contador_votosMadrid);
                i.putExtra("contadorValencia",contador_votosValencia);

                startActivity(i);
            }
        });

        //ClickListener para boton Madrid
        btn_madrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos un nuevo intent y le asignamos parametros
                Intent i = new Intent(Imagenes_activity.this,Descripcion_Activity.class);

                i.putExtra("ciudad",getString(R.string.madrid));
                i.putExtra("descripcion",getString(R.string.des_madrid));
                i.putExtra("votos",contador_votosMadrid);
                i.putExtra("contadorBilbao",contador_votosBilbao);
                i.putExtra("contadorBarcelona",contador_votosBarcelona);
                i.putExtra("contadorMadrid",contador_votosMadrid);
                i.putExtra("contadorValencia",contador_votosValencia);

                startActivity(i);
            }
        });

        //ClickListener para boton Valencia
        btn_valencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos un nuevo intent y le asignamos parametros
                Intent i = new Intent(Imagenes_activity.this,Descripcion_Activity.class);

                i.putExtra("ciudad",getString(R.string.valencia));
                i.putExtra("descripcion",getString(R.string.des_valencia));
                i.putExtra("votos",contador_votosValencia);
                i.putExtra("contadorBilbao",contador_votosBilbao);
                i.putExtra("contadorBarcelona",contador_votosBarcelona);
                i.putExtra("contadorMadrid",contador_votosMadrid);
                i.putExtra("contadorValencia",contador_votosValencia);

                startActivity(i);
            }
        });
    }

    /**
     * Actualiza los votos de la ciudad votada en la anterior activity
     */
    public void actualizarVotos(){
        try {
            //Recuperamos los datos del inten que nos envia la activity anterior
            Intent i = getIntent();
            contador_votosBilbao = getIntent().getIntExtra("contadorBilbao",0);
            contador_votosBarcelona = getIntent().getIntExtra("contadorBarcelona",0);
            contador_votosMadrid = getIntent().getIntExtra("contadorMadrid",0);
            contador_votosValencia = getIntent().getIntExtra("contadorValencia",0);
            //Actualizamos lbls de los votos
            lbl_votosBilbao.setText("Votos: "+contador_votosBilbao);
            lbl_votosBarcelona.setText("Votos: "+contador_votosBarcelona);
            lbl_votosMadrid.setText("Votos: "+contador_votosMadrid);
            lbl_votosValencia.setText("Votos: "+contador_votosValencia);
            String ciudad = getIntent().getStringExtra("ciudad");
            switch (ciudad){
                case "Bilbao":
                    contador_votosBilbao = getIntent().getIntExtra("votos",0);
                    lbl_votosBilbao.setText("Votos: "+contador_votosBilbao);
                    break;
                case "Barcelona":
                    contador_votosBarcelona = getIntent().getIntExtra("votos",0);
                    lbl_votosBarcelona.setText("Votos: "+contador_votosBarcelona);
                    break;
                case "Madrid":
                    contador_votosMadrid = getIntent().getIntExtra("votos",0);
                    lbl_votosMadrid.setText("Votos: "+contador_votosMadrid);
                    break;
                case "Valencia":
                    contador_votosValencia = getIntent().getIntExtra("votos",0);
                    lbl_votosValencia.setText("Votos: "+contador_votosValencia);
                    break;
            }
        }catch(Exception e){
            System.out.println("No se ha votado.");
        }
    }
}