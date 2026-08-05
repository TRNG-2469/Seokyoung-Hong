package com.rev.web.service;

import com.rev.web.dao.TodoDAO;
import com.rev.web.dao.TodoDAOImpl;
import com.rev.web.model.Todo;

import java.util.List;

public class TodoServiceImpl implements TodoService {

    public static final TodoDAO dao = new TodoDAOImpl();

    @Override
    public void create(Todo todo) {
        if (todo == null || todo.getTitle() == null || todo.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Todo is invalid");
        }

        dao.create(todo);
    }

    @Override
    public List<Todo> getAll() {
        return dao.getAll();
    }

    @Override
    public Todo getById(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID cannot be negative");
        }

        return dao.getById(id);
    }

    @Override
    public void update(Todo updatedTodo) {
        if (updatedTodo == null || updatedTodo.getTitle() == null || updatedTodo.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Todo is invalid");
        }
        dao.update(updatedTodo);
    }

    @Override
    public void delete(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID cannot be negative");
        }

        dao.delete(id);
    }
}
