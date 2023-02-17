package com.example.gira.model;

import com.example.gira.model.enums.Progress;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Progress progress;

    @Column(nullable = false)
    private LocalDate dueDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private Classification classification;

    @ManyToOne
    private User user;

    public Task() {
    }

    public Long getId() {
        return id;
    }


    public Task setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Task setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    public Progress getProgress() {
        return progress;
    }

    public Task setProgress(Progress progress) {
        this.progress = progress;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Task setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Classification getClassification() {
        return classification;
    }

    public Task setClassification(Classification classification) {
        this.classification = classification;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Task setUser(User user) {
        this.user = user;
        return this;
    }
}
