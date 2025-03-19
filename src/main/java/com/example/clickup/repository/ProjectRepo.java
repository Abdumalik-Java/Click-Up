package com.example.clickup.repository;

import com.example.clickup.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProjectRepo extends JpaRepository<Project, UUID> {
    Optional<Project> findByName(String name);
    boolean existsByName(String name);
}