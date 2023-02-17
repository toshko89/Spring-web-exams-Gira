package com.example.gira.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class TaskDTO {
    @NotBlank(message = "Name must not be empty!")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters!")
    private String name;

    @NotBlank(message = "Description must not be empty!")
    @Size(min = 5, message = "Description must be minimum 5 characters!")
    private String description;

    @NotNull(message = "Please select due date")
    @PastOrPresent
    private LocalDate dueDate;

    @NotBlank(message = "Please select classification")
    private String classification;

    public TaskDTO() {
    }

    public String getName() {
        return name;
    }

    public TaskDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskDTO setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public String getClassification() {
        return classification;
    }

    public TaskDTO setClassification(String classification) {
        this.classification = classification;
        return this;
    }
}
