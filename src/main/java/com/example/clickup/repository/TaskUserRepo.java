package com.example.clickup.repository;

import com.example.clickup.model.TaskUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskUserRepo extends JpaRepository<TaskUser, UUID> {
}