package com.alex.to_do.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.alex.to_do.model.Task;
import com.alex.to_do.model.dto.TaskDTO;


@Service
public class TaskService {
    private final Map<String,Task> storage = new ConcurrentHashMap<>();
    
    public Task createTask(TaskDTO task){
        Task infoTask = new Task(task.title(), task.priority(), task.description(), task.deadline());
        storage.put(infoTask.getId(),infoTask);

        return infoTask;
    }

    public List<Task> getAllTasksByPriority(){
        return storage.values().stream()
                .sorted(Comparator.comparing(Task::getPriority))
                .toList();
    }

    public List<Task> getAllTasksByTitle(){
        return storage.values().stream()
                .sorted(Comparator.comparing(Task::getTitle))
                .toList();
    }

    public List<Task> getPendingTasksByDeadline(){
        return storage.values().stream()
                .filter(task->!task.isCompleted())
                .sorted(Comparator.comparing(Task::getDeadline))
                .toList();
    }

    public Task toggleTaskCompletion(String id){
        Task task = storage.get(id);
        if(task != null){
            task.setCompleted(!task.isCompleted());
        }
        return task;
    }

    public Task editTask(String id, TaskDTO task){

        Task updatedTask = storage.get(id);

        updatedTask.setTitle(task.title());
        updatedTask.setPriority(task.priority());
        updatedTask.setDescription(task.description());
        updatedTask.setDeadline(task.deadline());
        
        return updatedTask;
    }

}
