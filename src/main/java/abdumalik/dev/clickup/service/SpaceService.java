package abdumalik.dev.clickup.service;

import abdumalik.dev.clickup.dto.SpaceDto;
import abdumalik.dev.clickup.model.*;
import abdumalik.dev.clickup.repository.IconRepo;
import abdumalik.dev.clickup.repository.SpaceRepo;
import abdumalik.dev.clickup.repository.UserRepo;
import abdumalik.dev.clickup.repository.WorkspaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SpaceService {

    @Autowired
    SpaceRepo repo;

    @Autowired
    WorkspaceRepo workspaceRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    IconRepo iconRepo;

    public List<Space> getAll() {
        return repo.findAll();
    }

    public Space getById(UUID id) {
        return repo.findById(id).get();
    }

    public Space getByName(String name) {
        return repo.findByName(name).get();
    }

    public Result create(SpaceDto dto) {
        Space space = new Space();
        space.setName(dto.getName());
        space.setColor(dto.getColor());
        space.setInitialLetter(dto.getInitialLetter());
        space.setAccessType(dto.getAccessType());
        space.setAvatarId(dto.getAvatarId());

        Optional<Workspace> byId = workspaceRepo.findById(dto.getWorkspaceId());
        Workspace workspace = byId.get();
        space.setWorkspaceId((List<Workspace>) workspace);

        Optional<User> byId1 = userRepo.findById(dto.getUserId());
        User user = byId1.get();
        space.setOwnerId(user);

        Optional<Icon> byId2 = iconRepo.findById(dto.getIconId());
        Icon icon = byId2.get();
        space.setIconId(icon);

        repo.save(space);
        return new Result("Space information successfully created", true);
    }

    public Result update(SpaceDto dto, UUID id) {
        Optional<Space> byId = repo.findById(id);
        if (byId.isPresent()) {
            Space space = byId.get();
            space.setName(dto.getName());
            space.setColor(dto.getColor());
            space.setInitialLetter(dto.getInitialLetter());
            space.setAccessType(dto.getAccessType());
            space.setAvatarId(dto.getAvatarId());

            Optional<Workspace> byWorkspaceId = workspaceRepo.findById(dto.getWorkspaceId());
            Workspace workspace = byWorkspaceId.get();
            space.setWorkspaceId((List<Workspace>) workspace);

            Optional<User> byUserId1 = userRepo.findById(dto.getUserId());
            User user = byUserId1.get();
            space.setOwnerId(user);

            Optional<Icon> byId2 = iconRepo.findById(dto.getIconId());
            Icon icon = byId2.get();
            space.setIconId(icon);

            repo.save(space);
            return new Result("Space information successfully updated", true);
        }
        return new Result("Space information not found", false);
    }

    public Result delete(UUID id) {
        Optional<Space> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Space information successfully deleted", true);
        }
        return new Result("Space information not found", false);
    }

}