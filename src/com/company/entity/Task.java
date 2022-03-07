package com.company.entity;

import java.time.LocalDate;

public class Task {


    private LocalDate date;
    private String type;
    private String name;
    private String description;

    public Task(LocalDate date, String type, String name, String description) {
        this.date = date;
        this.type = type;
        this.name = name;
        this.description = description;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
