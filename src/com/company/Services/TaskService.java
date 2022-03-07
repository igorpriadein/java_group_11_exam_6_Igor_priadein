package com.company.Services;

import com.company.Utils.JsonProvider;
import com.company.dtm.TasksModel;

public class TaskService {
    private final TasksModel tasks = new TasksModel(JsonProvider.getTasks());

    public TaskService() {

    }

    public TasksModel getTasks() {
        return tasks;
    }


}
