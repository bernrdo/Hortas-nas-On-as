package com.example.myapplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hortas {
    int id,quantMudas,quantAgua;
    String nomeHorta,dataPlantio,dataColheita;

    public Hortas(int id, int quantMudas, int quantAgua, String nomeHorta, String dataPlantio, String dataColheita) {
        this.id = id;
        this.quantMudas = quantMudas;
        this.quantAgua = quantAgua;
        this.nomeHorta = nomeHorta;
        this.dataPlantio = dataPlantio;
        this.dataColheita = dataColheita;
    }

    public int getId() {
        return id;
    }

    public int getQuantMudas() {
        return quantMudas;
    }

    public int getQuantAgua() {
        return quantAgua;
    }

    public String getNomeHorta() {
        return nomeHorta;
    }

    public String getDataPlantio() {
        return dataPlantio;
    }

    public String getDataColheita() {
        return dataColheita;
    }
    }
