package com.example.clickup.repository;

import com.example.clickup.model.TaskAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskAttachmentRepo extends JpaRepository<TaskAttachment, UUID> {
}