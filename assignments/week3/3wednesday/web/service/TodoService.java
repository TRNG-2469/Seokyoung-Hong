package com.rev.web.service;

import com.rev.web.model.Todo;

import java.util.List;

public interface TodoService {

    void create(Todo todo);
    List<Todo> getAll();
    Todo getById(int id);
    void update(Todo updatedTodo);
    void delete(int id);

}
