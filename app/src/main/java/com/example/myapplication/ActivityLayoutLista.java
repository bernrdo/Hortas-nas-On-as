package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ActivityLayoutLista extends AppCompatActivity {
    Button detalhes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_lista);

        detalhes = findViewById(R.id.buttonDetalhes);

        detalhes.setOnClickListener(v -> startActivity(new Intent(ActivityLayoutLista.this, Detalhes.class)));


    }
}
