package com.example.gira.model;

import com.example.gira.model.enums.ClassificaionName;
import jakarta.persistence.*;

@Entity
@Table(name = "classifications")
public class Classification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    @Enumerated(EnumType.STRING)
    private ClassificaionName name;

    private String description;

    public Classification() {
    }

    public Long getId() {
        return id;
    }

    public Classification setId(Long id) {
        this.id = id;
        return this;
    }

    public ClassificaionName getName() {
        return name;
    }

    public Classification setName(ClassificaionName name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Classification setDescription(String description) {
        this.description = description;
        return this;
    }
}
