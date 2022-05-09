package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BancoDeDados extends SQLiteOpenHelper {
    private final Context context;
    private static final String NOME_BANCO = "Hortadasoncas.db";
    private static final int VERSAO_BANCO = 1;

    private static final String NOME_TABELA = "Hortas";
    private static final String COLUNA_ID = "_id";
    private static final String COLUNA_NOME_HORTA ="Nome_Horta";
    private static final String COLUNA_AGUA = "Quantidade_Agua";
    private static final String COLUNA_MUDAS = "Quantidade_Mudas";
    private static final String COLUNA_DATA_PLANTIO = "Data_Plantio";
    private static final String COLUNA_DATA_COLHEITA = "Data_Colheita";
    private static final String COLUNA_MEDIA_AMADURECIMENTO = "Media_Amadurecimento";



    public BancoDeDados(@Nullable Context context) {
        super(context,NOME_BANCO,null,VERSAO_BANCO);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + NOME_TABELA +
                        " (" + COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUNA_NOME_HORTA + " TEXT, " +
                        COLUNA_AGUA + " INTEGER, " +
                        COLUNA_MUDAS + " INTEGER, " +
                        COLUNA_MEDIA_AMADURECIMENTO + " INTEGER, " +
                        COLUNA_DATA_PLANTIO + " TEXT, " +
                        COLUNA_DATA_COLHEITA + " TEXT); ";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NOME_TABELA);
        onCreate(db);

    }
    void addHorta(String Nome_Horta, Integer Mudas, String Data_Plantio) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUNA_NOME_HORTA, Nome_Horta);
        cv.put(COLUNA_MUDAS, Mudas);
        cv.put(COLUNA_DATA_PLANTIO, Data_Plantio);

       long result = db.insert(NOME_TABELA,null,cv);
       if (result == -1 ){
           Toast.makeText(context, "Falhou", Toast.LENGTH_SHORT).show();
       }else {
           Toast.makeText(context, "Adicionou", Toast.LENGTH_SHORT).show();
       }
    }
}
