package com.example.clickup.repository;

import com.example.clickup.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentRepo extends JpaRepository<Comment, UUID> {
}