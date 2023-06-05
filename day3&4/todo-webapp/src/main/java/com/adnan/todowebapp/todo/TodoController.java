package com.adnan.todowebapp.todo;

import java.time.LocalDate;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

// @Controller
@SessionAttributes("name")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    private String getLoggedinUsername(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
    
    @GetMapping("/")
    public String showTodos(ModelMap model) {
        model.put("name", getLoggedinUsername());

        model.put("todos", todoService.findByUsername(getLoggedinUsername()));

        return "list-todos";
    }

    @GetMapping("/add-todo")
    public String getAddTodoPage() {
        return "add-todo";
    }

    @PostMapping("/add-todo")
    public String addTodo(@RequestParam String description,@RequestParam LocalDate date) {

        todoService.addNewTodo(getLoggedinUsername(), description,date, "No");

        return "redirect:/";
    }

    @PostMapping("/mark-done")
    public String markDone(@RequestParam int id) {

        todoService.markDone(id);

        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteById(@RequestParam int id) {

        todoService.deleteById(id);

        return "redirect:/";
    }

}
