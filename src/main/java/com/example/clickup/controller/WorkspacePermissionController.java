package com.example.clickup.controller;

import com.example.clickup.dto.WorkspacePermissionDto;
import com.example.clickup.model.Result;
import com.example.clickup.model.WorkspacePermission;
import com.example.clickup.service.WorkspacePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/workspacePermission")
public class WorkspacePermissionController {

    @Autowired
    WorkspacePermissionService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN','USER')")
    public HttpEntity<?> readAll() {
        List<WorkspacePermission> list = service.getWorkspacePermissions();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readOne(@PathVariable UUID id) {
        WorkspacePermission workspacePermission = service.getWorkspacePermission(id);
        return new ResponseEntity<>(workspacePermission, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN','USER')")
    public HttpEntity<?> create(@RequestBody WorkspacePermissionDto workspacePermissionDto) {
        Result result = service.create(workspacePermissionDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN','USER')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody WorkspacePermissionDto workspacePermissionDto) {
        Result update = service.update(workspacePermissionDto, id);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN','USER')")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        Result result = service.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}