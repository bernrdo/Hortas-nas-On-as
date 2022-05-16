package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

public class Detalhes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        MaterialCalendarView materialCalendarView = findViewById(R.id.calendarView);

    }
}