package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ActivityProxColheita extends AppCompatActivity {
    SQLiteDatabase mDatabase;
    List<Hortas> ListaHortas ;
    ListView listView;



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listaprox);
        mDatabase = openOrCreateDatabase(ActivityAdicionar.DATABASE_NAME, MODE_PRIVATE, null);
        ListaHortas = new ArrayList<>();
        listView = findViewById(R.id.listViewHortas2);


        loadHortas();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void loadHortas(){
        String sql = "SELECT * FROM ListaHortas";

        Cursor cursor = mDatabase.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            do {
                ListaHortas.add(new Hortas(
                        cursor.getInt(0),
                        cursor.getInt(2),
                        cursor.getInt(3),
                        cursor.getString(1),
                        cursor.getString(4),
                        cursor.getString(5)));
            }while (cursor.moveToNext());

            Collections.sort(ListaHortas, new Comparator<Hortas>() {
                DateFormat f = new SimpleDateFormat("dd-MM-yyyy");
                @Override
                public int compare(Hortas o1, Hortas o2) {
                    try {
                        return f.parse(o1.getDataColheita()).compareTo(f.parse(o2.getDataColheita()));
                    } catch (ParseException e) {
                        throw new IllegalArgumentException(e);
                    }
                }
            });

            Adapter adapter = new Adapter(this,R.layout.activity_layout_lista,ListaHortas);
            listView.setAdapter(adapter);
        }
}}