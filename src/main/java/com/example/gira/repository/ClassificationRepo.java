package com.example.gira.repository;

import com.example.gira.model.Classification;
import com.example.gira.model.enums.ClassificaionName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassificationRepo extends JpaRepository<Classification,Long> {
    Classification findByName(ClassificaionName name);
}
