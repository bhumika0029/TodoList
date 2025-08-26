package com.app.TodoApp.controller;

import com.app.TodoApp.models.Task;
import com.app.TodoApp.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";  // maps to src/main/resources/templates/tasks.html (Thymeleaf)
    }

    @PostMapping
    public String createTask(@RequestParam String title) {
       taskService.createTask(title);
        return "redirect:/";  // maps to src/main/resources/templates/tasks.html (Thymeleaf)
    }
    @GetMapping("{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/";   // maps to src/main/resources/templates/tasks.html (Thymeleaf)
    }

    @GetMapping("{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        taskService.toggleTask(id);
        return "redirect:/";   // maps to src/main/resources/templates/tasks.html (Thymeleaf)
    }


}
