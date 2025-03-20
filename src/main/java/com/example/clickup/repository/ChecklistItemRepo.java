package com.example.clickup.repository;

import com.example.clickup.model.CheckListItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ChecklistItemRepo extends JpaRepository<CheckListItem, UUID> {
    Optional<CheckListItem> findByName(String name);
}