package abdumalik.dev.clickup.service;

import abdumalik.dev.clickup.dto.ProjectUserDto;
import abdumalik.dev.clickup.model.Project;
import abdumalik.dev.clickup.model.ProjectUser;
import abdumalik.dev.clickup.model.Result;
import abdumalik.dev.clickup.model.User;
import abdumalik.dev.clickup.repository.ProjectRepo;
import abdumalik.dev.clickup.repository.ProjectUserRepo;
import abdumalik.dev.clickup.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectUserService {

    @Autowired
    ProjectUserRepo repo;

    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    UserRepo userRepo;

    public List<ProjectUser> getProjectUsers() {
        return repo.findAll();
    }

    public ProjectUser getProjectUserById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(ProjectUserDto projectUserDto) {
        ProjectUser projectUser = new ProjectUser();

        Optional<Project> byId = projectRepo.findById(projectUserDto.getProjectId());
        Project project = byId.get();
        projectUser.setProjectId((List<Project>) project);

        Optional<User> byId1 = userRepo.findById(projectUserDto.getUserId());
        User user = byId1.get();
        projectUser.setUserId(user);

        repo.save(projectUser);
        return new Result("ProjectUser information successfully created", true);
    }

    public Result update(ProjectUserDto projectUserDto, UUID id) {
        Optional<ProjectUser> byId = repo.findById(id);
        if (byId.isPresent()) {
            ProjectUser projectUser = byId.get();

            Optional<Project> byId1 = projectRepo.findById(projectUserDto.getProjectId());
            Project project = byId1.get();
            projectUser.setProjectId((List<Project>) project);

            Optional<User> byId2 = userRepo.findById(projectUserDto.getUserId());
            User user = byId2.get();
            projectUser.setUserId(user);

            repo.save(projectUser);
            return new Result("ProjectUser information successfully updated", true);
        }
        return new Result("ProjectUser information not found", false);
    }

    public Result delete(UUID id) {
        Optional<ProjectUser> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("ProjectUser information successfully deleted", true);
        }
        return new Result("ProjectUser information not found", false);
    }

}