package com.todo.todoApp.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todo.todoApp.Models.Task;
import com.todo.todoApp.Repositories.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        try{
            return taskRepository.findAll();
        }catch(Exception e){
            throw new RuntimeException("Failed to get all tasks", e);
        }

    }

    public void addTask(String title){
        try{
            Task task = new Task(title, false);
            task.setTitle(title);
            task.setCompleted(false);
            taskRepository.save(task);
        }catch(Exception e){
            throw new RuntimeException("Failed to add task", e);
        }
    }

    public void deleteTask(Long taskId){
        try{
            taskRepository.deleteById(taskId);
        }catch(Exception e){
            throw new RuntimeException("Failed to delete task", e);
        }
    }

    public void toggleTask(Long id){
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task id: " + id));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}
