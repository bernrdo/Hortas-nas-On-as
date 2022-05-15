package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ActivityListaHorta extends AppCompatActivity {
    SQLiteDatabase mDatabase;
    List<Hortas> ListaHortas;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        mDatabase = openOrCreateDatabase(ActivityAdicionar.DATABASE_NAME, MODE_PRIVATE, null);
        ListaHortas = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listViewHortas);


        loadHortas();

    }

    private void loadHortas() {
        String sql = "SELECT * FROM ListaHortas";

        Cursor cursor = mDatabase.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                ListaHortas.add(new Hortas(
                        cursor.getInt(0),
                        cursor.getInt(2),
                        cursor.getInt(3),
                        cursor.getString(1),
                        cursor.getString(4),
                        cursor.getString(5)));
            } while (cursor.moveToNext());

            Adapter adapter = new Adapter(this, R.layout.activity_layout_lista, ListaHortas);
            listView.setAdapter(adapter);
        }


    }
}