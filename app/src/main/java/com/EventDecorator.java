package com;

import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Collection;

public class EventDecorator extends AppCompatActivity implements DayViewDecorator {

    private final int color = Color.parseColor("#FF0000");
    private final Collection<LocalDate> dates;

    public EventDecorator(Collection<LocalDate> dates) {

        this.dates = dates;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return dates=contains.da;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new DotSpan(5, color));
    }
}