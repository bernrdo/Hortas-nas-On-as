package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Adapter extends ArrayAdapter<Hortas> {
    Context mcTx;
    int layoutRes;
    List<Hortas> ListaHortas;

    public Adapter(Context mCtx, int layoutRes, List<Hortas> ListaHortas) {
        super(mCtx, layoutRes, ListaHortas);

        this.mcTx = mCtx;
        this.layoutRes = layoutRes;
        this.ListaHortas = ListaHortas;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mcTx);
        View view = inflater.inflate(layoutRes, null);
        TextView textViewNome = view.findViewById(R.id.textViewName);
        TextView textViewMudas = view.findViewById(R.id.textViewMudas);

        final Hortas horta = ListaHortas.get(position);
        textViewNome.setText(horta.getNomeHorta());
        textViewMudas.setText("Data Da Colheita : "+horta.getDataColheita());



        view.findViewById(R.id.buttonDetalhes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verDetalhes(horta);
            }
        });

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void verDetalhes(Hortas horta) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mcTx);
        LayoutInflater inflater = LayoutInflater.from(mcTx);
        View view = inflater.inflate(R.layout.activity_detalhes, null);
        builder.setView(view);


        AlertDialog alertDialog = builder.create();
        int width = (int) (getContext().getResources().getDisplayMetrics().widthPixels * 0.90);
        int height = (int) (getContext().getResources().getDisplayMetrics().heightPixels * 0.90);
        alertDialog.getWindow().setLayout(width, height);
        alertDialog.show();


        TextView textViewNomeDetalhes = view.findViewById(R.id.NomedaHorta);
        TextView textViewDiasColheitas = view.findViewById(R.id.diasColheita);
        TextView textViewDiaDoPlantio = view.findViewById(R.id.DiaPlantio);
        TextView textViewDiaDaColheita = view.findViewById(R.id.diaDaColheita);
        TextView textViewQuantAgua = view.findViewById(R.id.quantAgua);
        TextView textViewQuantMudas = view.findViewById(R.id.quantMudas);


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        LocalDate Data1 = LocalDate.parse(horta.getDataColheita(),dtf);
        LocalDate Data2 = LocalDate.parse(LocalDate.now().format(dtf).toString(),dtf);
        long dias = Duration.between(Data2.atStartOfDay(),Data1.atStartOfDay()).toDays();


        textViewNomeDetalhes.setText(horta.getNomeHorta());
        textViewDiasColheitas.setText("Faltam " + dias + " Dias Para a Colheita");
        textViewDiaDoPlantio.setText("Dia do Plantio: " + horta.getDataPlantio());
        textViewDiaDaColheita.setText("Dia da Colheita: " + horta.getDataColheita());
        textViewQuantAgua.setText("Quantidade de Água necessária: " + horta.getQuantAgua() + " Litros");
        textViewQuantMudas.setText("Quantidade de Mudas: " + horta.getQuantMudas());
    }
}