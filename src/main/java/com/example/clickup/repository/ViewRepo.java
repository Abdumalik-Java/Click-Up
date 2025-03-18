package com.example.clickup.repository;

import com.example.clickup.model.View;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ViewRepo extends JpaRepository<View, UUID> {
}