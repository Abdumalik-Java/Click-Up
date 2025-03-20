package com.example.clickup.controller;

import com.example.clickup.dto.WorkspaceRoleDto;
import com.example.clickup.model.Result;
import com.example.clickup.model.WorkspaceRole;
import com.example.clickup.service.WorkspaceRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/workspaceRole")
public class WorkspaceRoleController {

    @Autowired
    WorkspaceRoleService workspaceRoleService;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readAll() {
        List<WorkspaceRole> workspaceRoles = workspaceRoleService.getWorkspaceRoles();
        return new ResponseEntity<>(workspaceRoles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readById(@PathVariable UUID id) {
        WorkspaceRole workspaceRole = workspaceRoleService.getWorkspaceRole(id);
        return new ResponseEntity<>(workspaceRole, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> create(@RequestBody WorkspaceRoleDto workspaceRoleDto) {
        Result result = workspaceRoleService.create(workspaceRoleDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody WorkspaceRoleDto workspaceRoleDto) {
        Result update = workspaceRoleService.update(workspaceRoleDto, id);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        Result delete = workspaceRoleService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

}