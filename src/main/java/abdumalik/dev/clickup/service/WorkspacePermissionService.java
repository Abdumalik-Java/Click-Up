package abdumalik.dev.clickup.service;

import abdumalik.dev.clickup.dto.WorkspacePermissionDto;
import abdumalik.dev.clickup.model.Result;
import abdumalik.dev.clickup.model.WorkspacePermission;
import abdumalik.dev.clickup.model.WorkspaceRole;
import abdumalik.dev.clickup.repository.WorkspacePermissionRepo;
import abdumalik.dev.clickup.repository.WorkspaceRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WorkspacePermissionService {

    @Autowired
    WorkspacePermissionRepo repo;

    @Autowired
    WorkspaceRoleRepo workspaceRoleRepo;

    public List<WorkspacePermission> getWorkspacePermissions() {
        return repo.findAll();
    }

    public WorkspacePermission getWorkspacePermission(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(WorkspacePermissionDto dto) {
        WorkspacePermission permission = new WorkspacePermission();

        Optional<WorkspaceRole> byId = workspaceRoleRepo.findById(dto.getWorkspaceRoleId());
        WorkspaceRole workspaceRole = byId.get();
        permission.setWorkspaceRoleId(workspaceRole);

        repo.save(permission);
        return new Result("WorkspacePermission information successfully created and saved", true);
    }

    public Result update(WorkspacePermissionDto dto, UUID id) {
        Optional<WorkspacePermission> byId = repo.findById(id);
        if (byId.isPresent()) {
            WorkspacePermission permission = byId.get();

            Optional<WorkspaceRole> byId1 = workspaceRoleRepo.findById(dto.getWorkspaceRoleId());
            WorkspaceRole workspaceRole = byId1.get();
            permission.setWorkspaceRoleId(workspaceRole);

            repo.save(permission);
            return new Result("WorkspacePermission information successfully updated and saved", true);
        }
        return new Result("WorkspacePermission information not found", false);
    }

    public Result delete(UUID id) {
        Optional<WorkspacePermission> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("WorkspacePermission information successfully deleted", true);
        }
        return new Result("WorkspacePermission information not found", false);
    }

}