package com.example.clickup.repository;

import com.example.clickup.model.Space;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpaceRepo extends JpaRepository<Space, UUID> {
    Optional<Space> findByName(String name);
}