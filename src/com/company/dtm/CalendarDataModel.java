package com.company.dtm;

import com.company.entity.Day;

import java.util.List;

public class CalendarDataModel {
    private List<Day> daysList;

    public CalendarDataModel(List<Day> days) {
        daysList = days;
    }

    public List<Day> getDaysList() {
        return daysList;
    }

    public void setDaysList(List<Day> daysList) {
        this.daysList = daysList;
    }
}
