package com.alex.to_do.model;

import java.time.LocalDate;
import java.util.UUID;


public class Task {
    private final String id;
    private String title;
    private Priority priority;
    private String description;
    private LocalDate deadline;
    private boolean completed;

    public Task(String title, Priority priority, String description, LocalDate deadline){
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.priority = priority;
        this.description = description;
        this.deadline = deadline;
        this.completed = false;
    }

    public String getId(){ return id; }
    public String getTitle(){ return title; }
    public void setTitle(String title){
        this.title = title;
    }
    public Priority getPriority(){ return priority; }
    public void setPriority(Priority priority){
        this.priority = priority;
    }
    public String getDescription(){ return description; }
    public void setDescription(String description){
        this.description = description;
    }
    public LocalDate getDeadline(){ return deadline; }
    public void setDeadline(LocalDate deadline){
        this.deadline = deadline;
    }
    public boolean isCompleted(){ return completed; }
    public void setCompleted(boolean completed){
        this.completed = completed;
    }
}
