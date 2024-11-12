package com.todo.todoApp.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todo.todoApp.Models.Task;
import com.todo.todoApp.Services.TaskService;

@Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String getTasks(Model model) {   
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping("/tasks")
    public String addTask(@RequestParam String title) {
        taskService.addTask(title);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}/delete")
    public String deleteTask(@PathVariable Long id) {    
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}/toggle")
    public String completeTask(@PathVariable Long id) {    
        taskService.toggleTask(id); 
        return "redirect:/tasks";
    }
}
