package com.example.recyclerviewcasa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Adaptador adaptador;
    RecyclerView reclycler;

    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Encapsulador>lista = new ArrayList<>();
        lista.add(new Encapsulador(R.drawable.blackclover,"Serie1","Subtitulo Serie 1",false));
        lista.add(new Encapsulador(R.drawable.bleach,"Serie2","Subtitulo Serie 2",false));
        lista.add(new Encapsulador(R.drawable.bluelock,"Serie3","Subtitulo Serie 3",false));
        lista.add(new Encapsulador(R.drawable.fma,"Serie4","Subtitulo Serie 4",false));
        lista.add(new Encapsulador(R.drawable.boku_no_pico,"Serie5","Subtitulo Serie 5",false));

        adaptador = new Adaptador(lista,this,R.layout.elemento);
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View vistaGeneral = (View)findViewById(R.id.vistaGeneral);
                int position = reclycler.getChildAdapterPosition(view);
                String cadena = "Has seleccionado : "+lista.get(position).getTitulo();
                Snackbar snackbar = Snackbar.make(vistaGeneral,cadena,Snackbar.LENGTH_SHORT );
                snackbar.show();
            }
        });


        reclycler = (RecyclerView) findViewById(R.id.recycler);
        reclycler.setAdapter(adaptador);
        layoutManager = new LinearLayoutManager(this);
        reclycler.setLayoutManager(layoutManager);


    }
}