package com.adnan.todowebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    private static int todoCount = 0;

    public List<Todo> findByUsername(String username) {
        

        return todos.stream().filter(todo -> todo.getUsername().equals(username)).toList();
    }

    public void addNewTodo(String username, String description, LocalDate targetDate, String done) {
        todos.add(new Todo(username, description, targetDate, done));
    }

    public void markDone(int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                todo.setDone("Yes");
            }
        }
    }

    public void deleteById(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }

}
