package com.example.clickup.repository;

import com.example.clickup.model.WorkspaceUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkspaceUserRepo extends JpaRepository<WorkspaceUser, UUID> {
}
