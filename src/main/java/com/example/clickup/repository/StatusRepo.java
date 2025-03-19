package com.example.clickup.repository;

import com.example.clickup.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StatusRepo extends JpaRepository<Status, UUID> {
}