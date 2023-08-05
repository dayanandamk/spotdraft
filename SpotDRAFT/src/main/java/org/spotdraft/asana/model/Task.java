package org.spotdraft.asana.model;

import java.time.LocalDate;

public class Task {
    private String taskId;
    private String name;
    private String assignee;
    private LocalDate dueDate;
    private String description;

    // Constructors, getters, setters, and other methods

    public Task() {
        // Default constructor
    }

    public Task(String taskId, String name, String assignee, LocalDate dueDate, String description) {
        this.taskId = taskId;
        this.name = name;
        this.assignee = assignee;
        this.dueDate = dueDate;
        this.description = description;
    }
}
