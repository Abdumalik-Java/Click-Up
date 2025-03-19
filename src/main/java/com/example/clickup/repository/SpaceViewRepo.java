package com.example.clickup.repository;

import com.example.clickup.model.SpaceView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpaceViewRepo extends JpaRepository<SpaceView, UUID> {
}