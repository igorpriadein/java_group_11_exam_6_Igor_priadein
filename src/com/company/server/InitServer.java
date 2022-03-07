package com.company.server;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.company.Services.TaskService;
import com.company.dtm.CalendarDataModel;
import com.company.dtm.TasksModel;
import com.sun.net.httpserver.HttpExchange;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class InitServer extends BasicServer {
    private final static Configuration freemarker = initFreeMarker();
    private final TaskService taskService = new TaskService();

    public InitServer(String host, int port) throws IOException {
        super(host, port);
        registerGet("/", this::indexHandler);
        registerGet("/tasks", this::tasksHandler);
    }

    private static Configuration initFreeMarker() {
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
            cfg.setDirectoryForTemplateLoading(new File("data"));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setLogTemplateExceptions(false);
            cfg.setWrapUncheckedExceptions(true);
            cfg.setFallbackOnNullLoopVariable(false);
            return cfg;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void indexHandler(HttpExchange exchange) {
        //var dataModel = new CalendarDataModel();
        renderTemplate(exchange, "index.html", getDataModel());
    }

    private void tasksHandler(HttpExchange exchange) {
        var dataModel  =  taskService.getTasks();
        renderTemplate(exchange, "tasks.ftl", dataModel);
    }


    protected void renderTemplate(HttpExchange exchange, String templateFile, Object dataModel) {
        try {
            Template temp = freemarker.getTemplate(templateFile);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            try (OutputStreamWriter writer = new OutputStreamWriter(stream)) {
                temp.process(dataModel, writer);
                writer.flush();
                var data = stream.toByteArray();
                sendByteData(exchange, ResponseCodes.OK, ContentType.TEXT_HTML, data);
            }
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }

    }


    private CalendarDataModel getDataModel() {
        return new CalendarDataModel();
    }
}
