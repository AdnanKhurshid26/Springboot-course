package com.adnan.todowebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
    
    private TodoService todoService;
    private TodoRepository todoRepository;
    public TodoControllerJpa(TodoService todoService,TodoRepository todoRepository) {
        super();
        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    private String getLoggedinUsername(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
    
    @GetMapping("/")
    public String showTodos(ModelMap model) {
        String name = getLoggedinUsername();
        model.put("name", name);
        List<Todo> todos = todoRepository.findByUsername(name);
        model.put("todos",todos);

        return "list-todos";
    }

    @GetMapping("/add-todo")
    public String getAddTodoPage() {
        return "add-todo";
    }

    @PostMapping("/add-todo")
    public String addTodo(@RequestParam String description,@RequestParam LocalDate date) {
        
        todoRepository.save(new Todo(
            getLoggedinUsername(), description,date, "No"
        ));

        return "redirect:/";
    }

    @PostMapping("/mark-done")
    public String markDone(@RequestParam int id) {

        Todo todo = todoRepository.findById(id).get();
        todo.setDone("Yes");
        todoRepository.save(todo);

        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteById(@RequestParam int id) {

        todoRepository.deleteById(id);

        return "redirect:/";
    }

}
