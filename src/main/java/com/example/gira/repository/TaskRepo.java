package com.example.gira.repository;

import com.example.gira.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task,Long>{
}
