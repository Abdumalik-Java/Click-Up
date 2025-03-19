package com.example.clickup.repository;

import com.example.clickup.model.ProjectUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectUserRepo extends JpaRepository<ProjectUser, UUID> {
}