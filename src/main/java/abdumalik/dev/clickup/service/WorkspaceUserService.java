package abdumalik.dev.clickup.service;

import abdumalik.dev.clickup.dto.WorkspaceUserDto;
import abdumalik.dev.clickup.model.*;
import abdumalik.dev.clickup.repository.UserRepo;
import abdumalik.dev.clickup.repository.WorkspaceRepo;
import abdumalik.dev.clickup.repository.WorkspaceRoleRepo;
import abdumalik.dev.clickup.repository.WorkspaceUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WorkspaceUserService {

    @Autowired
    WorkspaceUserRepo repo;

    @Autowired
    WorkspaceRepo workspaceRepo;

    @Autowired
    WorkspaceRoleRepo workspaceRoleRepo;

    @Autowired
    UserRepo userRepo;

    public List<WorkspaceUser> getAll() {
        return repo.findAll();
    }

    public WorkspaceUser getById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(WorkspaceUserDto dto) {
        WorkspaceUser workspaceUser = new WorkspaceUser();

        Optional<Workspace> byId = workspaceRepo.findById(dto.getWorkspaceId());
        Workspace workspace = byId.get();
        workspaceUser.setWorkspaceId(workspace);

        Optional<WorkspaceRole> byId1 = workspaceRoleRepo.findById(dto.getWorkspaceRoleId());
        WorkspaceRole workspaceRole = byId1.get();
        workspaceUser.setWorkspaceRoleId(workspaceRole);

        Optional<User> byId2 = userRepo.findById(dto.getUserId());
        User user = byId2.get();
        workspaceUser.setUserId(user);

        repo.save(workspaceUser);
        return new Result("WorkspaceUser information created successfully", true);
    }

    public Result update(WorkspaceUserDto dto, UUID id) {
        Optional<WorkspaceUser> byId = repo.findById(id);
        if (byId.isPresent()) {
            WorkspaceUser workspaceUser = byId.get();

            Optional<WorkspaceRole> byId1 = workspaceRoleRepo.findById(dto.getWorkspaceRoleId());
            WorkspaceRole workspaceRole = byId1.get();
            workspaceUser.setWorkspaceRoleId(workspaceRole);

            Optional<User> byId2 = userRepo.findById(dto.getUserId());
            User user = byId2.get();
            workspaceUser.setUserId(user);

            Optional<Workspace> byId3 = workspaceRepo.findById(dto.getWorkspaceId());
            Workspace workspace = byId3.get();
            workspaceUser.setWorkspaceId(workspace);

            repo.save(workspaceUser);
            return new Result("WorkspaceUser information updated successfully", true);
        }
        return new Result("WorkspaceUser information not found", false);
    }

    public Result delete(UUID id) {
        Optional<WorkspaceUser> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("WorkspaceUser information deleted successfully", true);
        }
        return new Result("WorkspaceUser information not found", false);
    }

}