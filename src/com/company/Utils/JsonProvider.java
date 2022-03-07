package com.company.Utils;


import com.company.entity.Task;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonProvider {
    private final static Gson gson = new Gson();

    public static List<Task> getTasks() {
        Type listType = new TypeToken<ArrayList<Task>>() {
        }.getType();
        try (Reader reader = new FileReader("tasks.json")) {
            List<Task> tasks = gson.fromJson(reader, listType);
            return tasks;
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public static void writeTasks(List<Task> books) throws IOException {
        try (Writer writer = new FileWriter("tasks.json")) {
            String json = gson.toJson(books);
            writer.write(json);
        }
    }
}
