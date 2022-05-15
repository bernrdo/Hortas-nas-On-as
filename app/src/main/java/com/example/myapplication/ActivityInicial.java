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
        ButtonInfo = findViewById(R.id.buttonInfo);
        ButtonLista = findViewById(R.id.buttonLista);
        ButtonCalendario = findViewById(R.id.buttonCalendario);
        ButtonProx = findViewById(R.id.buttonProx);
        ButtonAdd = findViewById(R.id.buttonAdd);

        ButtonLista.setOnClickListener(v -> startActivity(new Intent(ActivityInicial.this, ActivityListaHorta.class)));
        ButtonAdd.setOnClickListener(v -> startActivity(new Intent(ActivityInicial.this, ActivityAdicionar.class)));
        ButtonProx.setOnClickListener(v -> startActivity(new Intent(ActivityInicial.this, ActivityProxColheita.class)));
        ButtonProx.setOnClickListener(v -> startActivity(new Intent(ActivityInicial.this, ActivityProxColheita.class)));
        ButtonCalendario.setOnClickListener(v -> startActivity(new Intent(ActivityInicial.this, MainActivity6.class)));

    }
}