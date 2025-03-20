package com.example.clickup.repository;

import com.example.clickup.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TagRepo extends JpaRepository<Tag, UUID> {
}