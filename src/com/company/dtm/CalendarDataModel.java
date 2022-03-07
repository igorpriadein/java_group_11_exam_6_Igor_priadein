package com.company.dtm;

import com.company.entity.Day;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalendarDataModel {
    private List<Day> daysList = new ArrayList<>();

    public CalendarDataModel() {
        daysList.add(new Day(LocalDate.of(2022, 1,1)));
        daysList.add(new Day(LocalDate.of(2022,1,2)));
        daysList.add(new Day(LocalDate.of(2022,1,3)));
        daysList.add(new Day(LocalDate.of(2022,1,4)));
        daysList.add(new Day(LocalDate.of(2022,1,5)));
        daysList.add(new Day(LocalDate.of(2022,1,6)));

    }

    public List<Day> getDaysList() {
        return daysList;
    }

    public void setDaysList(List<Day> daysList) {
        this.daysList = daysList;
    }
}
