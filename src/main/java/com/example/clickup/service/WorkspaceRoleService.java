package com.example.clickup.service;

import com.example.clickup.dto.WorkspaceRoleDto;
import com.example.clickup.model.Result;
import com.example.clickup.model.Workspace;
import com.example.clickup.model.WorkspaceRole;
import com.example.clickup.repository.WorkspaceRepo;
import com.example.clickup.repository.WorkspaceRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WorkspaceRoleService {

    @Autowired
    WorkspaceRoleRepo repo;

    @Autowired
    WorkspaceRepo workspaceRepo;

    public List<WorkspaceRole> getWorkspaceRoles() {
        return repo.findAll();
    }

    public WorkspaceRole getWorkspaceRole(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(WorkspaceRoleDto dto) {
        WorkspaceRole role = new WorkspaceRole();
        role.setName(dto.getName());
        role.setExtendsRoleName(dto.getExtendsRoleName());

        Optional<Workspace> byId = workspaceRepo.findById(dto.getWorkspaceId());
        Workspace workspace = byId.get();
        role.setWorkspaceId((List<Workspace>) workspace);

        repo.save(role);
        return new Result("WorkspaceRole information created successfully", true);
    }

    public Result update(WorkspaceRoleDto dto, UUID id) {
        Optional<WorkspaceRole> byId = repo.findById(id);
        if (byId.isPresent()) {
            WorkspaceRole role = byId.get();
            role.setName(dto.getName());
            role.setExtendsRoleName(dto.getExtendsRoleName());

            Optional<Workspace> byId1 = workspaceRepo.findById(dto.getWorkspaceId());
            Workspace workspace = byId1.get();
            role.setWorkspaceId((List<Workspace>) workspace);

            repo.save(role);
            return new Result("WorkspaceRole information updated successfully", true);
        }
        return new Result("WorkspaceRole information not found", false);
    }

    public Result delete(UUID id) {
        Optional<WorkspaceRole> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("WorkspaceRole information deleted successfully", true);
        }
        return new Result("WorkspaceRole information not found", false);
    }

}