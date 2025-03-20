package com.example.clickup.repository;

import com.example.clickup.model.CategoryUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryUserRepo extends JpaRepository<CategoryUser, UUID> {
    Optional<CategoryUser> findByName(String name);
}