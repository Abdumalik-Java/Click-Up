package com.example.clickup.repository;

import com.example.clickup.model.CheckList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CheckListRepo extends JpaRepository<CheckList, UUID> {
    Optional<CheckList> findByName(String name);
}