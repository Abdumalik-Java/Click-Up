package com.example.clickup.repository;

import com.example.clickup.model.SpaceUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpaceUserRepo extends JpaRepository<SpaceUser, UUID> {
}