package com.example.clickup.repository;

import com.example.clickup.model.TaskHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskHistoryRepo extends JpaRepository<TaskHistory, UUID> {
}