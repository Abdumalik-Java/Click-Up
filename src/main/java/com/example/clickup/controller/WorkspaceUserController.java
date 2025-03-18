package com.example.clickup.controller;

import com.example.clickup.dto.WorkspaceUserDto;
import com.example.clickup.model.Result;
import com.example.clickup.model.WorkspaceUser;
import com.example.clickup.service.WorkspaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/workspaceUser")
public class WorkspaceUserController {

    @Autowired
    WorkspaceUserService workspaceUserService;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readAll() {
        List<WorkspaceUser> all = workspaceUserService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> readById(@PathVariable UUID id) {
        WorkspaceUser workspaceUser = workspaceUserService.getById(id);
        return new ResponseEntity<>(workspaceUser, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> create(@RequestBody WorkspaceUserDto workspaceUserDto) {
        Result result = workspaceUserService.create(workspaceUserDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody WorkspaceUserDto workspaceUserDto) {
        Result update = workspaceUserService.update(workspaceUserDto, id);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        Result delete = workspaceUserService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

}