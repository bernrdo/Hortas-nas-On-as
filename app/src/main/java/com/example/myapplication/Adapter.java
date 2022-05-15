package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
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
        @SuppressLint("ViewHolder") View view = inflater.inflate(layoutRes, null);
        TextView textViewNome = view.findViewById(R.id.textViewName);
        TextView textViewMudas = view.findViewById(R.id.textViewMudas);
        MaterialCalendarView materialCalendarView = view.findViewById(R.id.calendarView);
        Collection datas = new ArrayList();


        final Hortas horta = ListaHortas.get(position);
        textViewNome.setText(horta.getNomeHorta());
        textViewMudas.setText(MessageFormat.format("Data Da Colheita : {0}", horta.getDataColheita()));
        datas.add(horta.getDataColheita());


        view.findViewById(R.id.buttonDetalhes).setOnClickListener(v -> verDetalhes(horta));

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
        @SuppressLint("SimpleDateFormat") DateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        LocalDate Data1 = LocalDate.parse(horta.getDataColheita(),dtf);
        LocalDate Data2 = LocalDate.parse(LocalDate.now().format(dtf),dtf);
        long dias = Duration.between(Data2.atStartOfDay(),Data1.atStartOfDay()).toDays();


        textViewNomeDetalhes.setText(horta.getNomeHorta());
        textViewDiasColheitas.setText(MessageFormat.format("Faltam {0} Dias Para a Colheita", dias));
        textViewDiaDoPlantio.setText(MessageFormat.format("Dia do Plantio: {0}", horta.getDataPlantio()));
        textViewDiaDaColheita.setText(MessageFormat.format("Dia da Colheita: {0}", horta.getDataColheita()));
        textViewQuantAgua.setText(MessageFormat.format("Quantidade de Água necessária: {0} Litros", horta.getQuantAgua()));
        textViewQuantMudas.setText(MessageFormat.format("Quantidade de Mudas: {0}", horta.getQuantMudas()));
    }
    public static class EventDecorator implements DayViewDecorator {

        private final int color;
        private final HashSet<CalendarDay> dates;

        public EventDecorator(int color, Collection<CalendarDay> dates) {
            this.color = color;
            this.dates = new HashSet<>(dates);
        }

        @Override
        public boolean shouldDecorate(CalendarDay day) {
            return dates.contains(day);
        }

        @Override
        public void decorate(DayViewFacade view) {
            view.addSpan(new DotSpan(5, color));
        }
    }

        }





