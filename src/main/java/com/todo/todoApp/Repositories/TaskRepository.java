package com.todo.todoApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.todoApp.Models.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
    
}
