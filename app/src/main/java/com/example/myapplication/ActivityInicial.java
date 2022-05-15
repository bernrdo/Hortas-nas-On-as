package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;

public class ActivityInicial extends AppCompatActivity {
    Button ButtonInfo, ButtonLista, ButtonCalendario,ButtonProx,ButtonAdd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);
        ButtonInfo = (Button) findViewById(R.id.buttonInfo);
        ButtonLista = (Button) findViewById(R.id.buttonLista);
        ButtonCalendario = (Button) findViewById(R.id.buttonCalendario);
        ButtonProx = (Button) findViewById(R.id.buttonProx);
        ButtonAdd = (Button) findViewById(R.id.buttonAdd);

        ButtonLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityInicial.this, ActivityListaHorta.class));
            }
        });
        ButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityInicial.this, ActivityAdicionar.class));
            }
        });
        ButtonProx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityInicial.this, ActivityProxColheita.class));
            }
        });
        ButtonProx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityInicial.this, ActivityProxColheita.class));
            }
        });

    }
}