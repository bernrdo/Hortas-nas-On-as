package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ActivityAdicionar extends AppCompatActivity {
    public static final String DATABASE_NAME = "MinhaDB";
    Button ButtonSalvar;

    SQLiteDatabase mDatabase;

    EditText input_nome, input_mudas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar);

        ButtonSalvar = findViewById(R.id.button_salvarHorta);
        ButtonSalvar.setOnClickListener(v -> addHorta());


        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        createTable();

        input_nome = findViewById(R.id.input_nome);
        input_mudas = findViewById(R.id.input_mudas);

    }

    private void createTable() {

        String sql = "CREATE TABLE IF NOT EXISTS ListaHortas (\n" +
                "  id INTEGER NOT NULL CONSTRAINT HORTAS_PK PRIMARY KEY AUTOINCREMENT, " +
                " Nome_Horta varchar(200) NOT NULL,\n" +
                " Quant_Mudas INTEGER NOT NULL,\n" +
                " Quant_Agua INTEGER NOT NULL,\n" +
                " DATA_PLANTIO datetime NOT NULL,\n " +
                " DATA_COLHEITA  datetime NOT NULL\n" +
                ");";
        mDatabase.execSQL(sql);
    }

    private void addHorta() {
        String nomeHorta = input_nome.getText().toString().trim();
        String quantMudas = input_mudas.getText().toString().trim();
        Calendar cal = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String dataPlantio = sdf.format(cal.getTime());
        cal = Calendar.getInstance();
        cal.add((Calendar.DATE), 35);
        String dataColheita = sdf.format(cal.getTime());


        String sql = "INSERT INTO ListaHortas(Nome_Horta,Quant_Mudas,Quant_Agua,DATA_PLANTIO,DATA_COLHEITA)" +
                "VALUES (?,?,?,?,?)";

        mDatabase.execSQL(sql, new String[]{nomeHorta, quantMudas, String.valueOf(Integer.parseInt(quantMudas) * 5), dataPlantio, dataColheita});
        Toast.makeText(this, "Horta Adicionada", Toast.LENGTH_SHORT).show();
    }


}
