package com.example.clickup.repository;

import com.example.clickup.model.WorkspaceRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkspaceRoleRepo extends JpaRepository<WorkspaceRole, UUID> {
}