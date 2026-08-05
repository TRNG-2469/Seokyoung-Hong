package com.rev.web.dao;

import com.rev.web.model.Todo;

import java.util.List;

public interface TodoDAO {

    void create(Todo todo);
    List<Todo> getAll();
    Todo getById(int id);
    void update(Todo updatedTodo);
    void delete(int id);

}
