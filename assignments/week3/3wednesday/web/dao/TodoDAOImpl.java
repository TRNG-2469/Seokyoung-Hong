package com.rev.web.dao;

import com.rev.web.model.Todo;
import com.rev.web.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDAOImpl implements TodoDAO {


    @Override
    public void create(Todo todo) {
        String insertQuery = "INSERT INTO todos (title, is_completed) VALUES (?, ?)";

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement ps = conn.prepareStatement(insertQuery);
            ps.setString(1, todo.getTitle());
            ps.setBoolean(2, todo.isCompleted());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Todo> getAll() {
        String getQuery = "SELECT * FROM todos";
        List<Todo> todoList = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement ps = conn.prepareStatement(getQuery);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Todo todo = new Todo(rs.getInt(1), rs.getString(2), rs.getBoolean(3));
                todoList.add(todo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return todoList;
    }

    @Override
    public Todo getById(int id) {
        String getQuery = "SELECT * FROM todos WHERE todo_id = ?";

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement ps = conn.prepareStatement(getQuery);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Todo todo = new Todo(rs.getInt(1), rs.getString(2), rs.getBoolean(3));
                return todo;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void update(Todo updatedTodo) {
        String insertQuery = "UPDATE todos SET title = ?, is_completed = ? WHERE todo_id = ?";

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement ps = conn.prepareStatement(insertQuery);
            ps.setString(1, updatedTodo.getTitle());
            ps.setBoolean(2, updatedTodo.isCompleted());
            ps.setInt(3, updatedTodo.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String deleteQuery = "DELETE FROM todos WHERE todo_id = ?";

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement ps = conn.prepareStatement(deleteQuery);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
