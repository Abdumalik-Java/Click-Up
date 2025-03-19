package com.example.clickup.repository;

import com.example.clickup.model.WorkspacePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkspacePermissionRepo extends JpaRepository<WorkspacePermission, UUID> {
}