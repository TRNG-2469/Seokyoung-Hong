package com.rev.web.controllers;

import com.rev.web.model.Todo;
import com.rev.web.service.TodoService;
import com.rev.web.service.TodoServiceImpl;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TodoController {

    private static final ConcurrentHashMap<Integer, Todo> db = new ConcurrentHashMap<>();
    private static final AtomicInteger idSequence = new AtomicInteger(0);
    public static final TodoService service = new TodoServiceImpl();

    static {
        int id1 = idSequence.incrementAndGet();
        db.put(id1, new Todo(id1, "learn Javalin", false));

        int id2 = idSequence.incrementAndGet();
        db.put(2, new Todo(id2, "Build app", false));
    }

    // 1. GET all todos
    public static void getAllTodos(Context ctx) {
        List<Todo> todos = service.getAll();
        ctx.json(todos);
    }

    public static void getTodoById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Todo myTodo = service.getById(id);

        if (myTodo == null) {
            throw new NotFoundResponse("Todo with id " + id + " not found");
        }

        ctx.json(myTodo);
    }

    //3 create todo
    public static void createTodo(Context ctx) {
        Todo payload = ctx.bodyAsClass(Todo.class);
        Todo newTodo = new Todo(payload.getTitle(), payload.isCompleted());

        service.create(newTodo);

        ctx.status(201);
        ctx.json(newTodo);
    }

    //4 update todo
    public static void updateTodo(Context ctx) {
        Todo payload = ctx.bodyAsClass(Todo.class);

        //make a check to see if title or complete are null or not
        if (payload.getTitle() == null || payload.getTitle().isEmpty() || payload.getId() < 0) {
            throw new IllegalArgumentException("Title or fields invalid");
        }

        Todo updatedTodo = new Todo(payload.getId(), payload.getTitle(), payload.isCompleted());
        service.update(updatedTodo);
        ctx.json(updatedTodo);

    }

    public static void deleteTodo(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        service.delete(id);
        ctx.status(204);
    }

}



