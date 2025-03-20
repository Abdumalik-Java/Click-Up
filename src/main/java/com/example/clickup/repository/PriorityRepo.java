package com.example.clickup.repository;

import com.example.clickup.model.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PriorityRepo extends JpaRepository<Priority, UUID> {
}