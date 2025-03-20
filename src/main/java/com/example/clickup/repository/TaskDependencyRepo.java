package com.example.clickup.repository;

import com.example.clickup.model.TaskDependency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskDependencyRepo extends JpaRepository<TaskDependency, UUID> {
}