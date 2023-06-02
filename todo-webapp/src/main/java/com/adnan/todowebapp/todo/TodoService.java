package com.adnan.todowebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    static{
        todos.add(new Todo(1, "adnan", "Learn Spring Boot", LocalDate.now(), false));
        todos.add(new Todo(2, "adnan", "Learn MongoDB", LocalDate.now().plusDays(1), false));
        todos.add(new Todo(3, "adnan", "Learn Design Patterns", LocalDate.now().plusDays(2), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }

}
