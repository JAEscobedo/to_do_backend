package com.alex.to_do.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alex.to_do.Service.TaskService;
import com.alex.to_do.model.Task;
import com.alex.to_do.model.dto.TaskDTO;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping    
    public Task createTask(@RequestBody TaskDTO task){
        return taskService.createTask(task);
    }

    @GetMapping("/byPriority")
    public List<Task> getByPriority(){
        return taskService.getAllTasksByPriority();
    }

    @GetMapping("/byTitle")
    public List<Task> getByTitle() {
        return taskService.getAllTasksByTitle();
    }
    
    
    @GetMapping("/pending")
    public List<Task> getPendingByDeadline(){
        return taskService.getPendingTasksByDeadline();
    }

    @PutMapping("/{id}/toggle")
    public Task toggleCompletion(@PathVariable String id){
        return taskService.toggleTaskCompletion(id);
    }

    @PutMapping("edit/{id}")
    public Task ediTask(@PathVariable String id, @RequestBody TaskDTO task) {
        return  taskService.editTask(id, task);
    }
}
