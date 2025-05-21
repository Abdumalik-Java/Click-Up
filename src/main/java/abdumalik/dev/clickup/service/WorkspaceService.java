package abdumalik.dev.clickup.service;

import abdumalik.dev.clickup.dto.WorkspaceDto;
import abdumalik.dev.clickup.model.Result;
import abdumalik.dev.clickup.model.User;
import abdumalik.dev.clickup.model.Workspace;
import abdumalik.dev.clickup.repository.UserRepo;
import abdumalik.dev.clickup.repository.WorkspaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WorkspaceService {

    @Autowired
    WorkspaceRepo repo;

    @Autowired
    UserRepo userRepo;

    public List<Workspace> findAll() {
        return repo.findAll();
    }

    public Workspace findById(UUID id) {
        return repo.findById(id).get();
    }

    public Workspace findByName(String name) {
        return repo.findByName(name).get();
    }

    public Result create(WorkspaceDto dto) {
        Workspace workspace = new Workspace();
        workspace.setName(dto.getName());
        workspace.setColor(dto.getColor());
        workspace.setInitialLetter(dto.getInitialLetter());
        workspace.setAvatarId(dto.getAvatarId());

        Optional<User> byId = userRepo.findById(dto.getOwnerId());
        User user = byId.get();
        workspace.setOwnerId(user);

        repo.save(workspace);
        return new Result("Workspace information created successfully", true);
    }

    public Result update(WorkspaceDto dto, UUID id) {
        Optional<Workspace> byId = repo.findById(id);
        if (byId.isPresent()) {
            Workspace workspace = byId.get();
            workspace.setName(dto.getName());
            workspace.setColor(dto.getColor());
            workspace.setInitialLetter(dto.getInitialLetter());
            workspace.setAvatarId(dto.getAvatarId());

            Optional<User> byOwnerId = userRepo.findById(dto.getOwnerId());
            User user = byOwnerId.get();
            workspace.setOwnerId(user);

            repo.save(workspace);
            return new Result("Workspace information updated successfully", true);
        }
        return new Result("Workspace not found", false);
    }

    public Result delete(UUID id) {
        Optional<Workspace> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Workspace information deleted successfully", true);
        }
        return new Result("Workspace not found", false);
    }

}