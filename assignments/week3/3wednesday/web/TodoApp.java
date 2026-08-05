package com.rev.web;

import com.rev.web.controllers.TodoController;
import com.rev.web.exceptions.ErrorResponse;
import com.rev.web.model.Todo;
import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TodoApp {

    public static void main(String[] args) {

        //Initialize, start Javalin
        Javalin app = Javalin.create().start(8080);

        // 1) Retrieve all Todos
        app.get("/api/todos", TodoController::getAllTodos);

        // 2) Retrieve Todos based on id
        app.get("/api/todos/{id}", TodoController::getTodoById);

        //3 POST DATA
        app.post("api/todos", TodoController::createTodo);

        //4 Update data
        app.put("api/todos/{id}", TodoController::updateTodo);

        // 5) Delete todo based on id
        app.delete("/api/todos/{id}", TodoController::deleteTodo);

        //Centralized Exception Handling
        //Otherwise you must write try/catch for every handler
        app.exception(IllegalArgumentException.class, (e, ctx) -> {
            ctx.status(400);
            ctx.json(new ErrorResponse("An unexpected error has occurred"));
        });

        app.exception(Exception.class, (e, ctx) -> {
            e.printStackTrace();
            ctx.status(500);
            ctx.json(new ErrorResponse("An unexpected Server error occurred"));
        });

    }

}
