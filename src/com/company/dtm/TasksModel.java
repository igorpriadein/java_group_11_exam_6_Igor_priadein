package com.company.dtm;

import com.company.Utils.JsonProvider;
import com.company.entity.Task;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TasksModel {
    private List<Task> tasksList;

    public TasksModel(List<Task> tasks) {
        tasksList = tasks;
    }

    public List<Task> getTasksList() {
        return tasksList;
    }

    public void setBookList(List<Task> bookList) {
        this.tasksList = tasksList;
    }
}
