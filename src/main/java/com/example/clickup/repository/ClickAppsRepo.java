package com.example.clickup.repository;

import com.example.clickup.model.ClickApps;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClickAppsRepo extends JpaRepository<ClickApps, UUID> {
    Optional<ClickApps> findByName(String name);
}