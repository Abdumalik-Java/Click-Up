package abdumalik.dev.clickup.service;

import abdumalik.dev.clickup.dto.ProjectDto;
import abdumalik.dev.clickup.model.Project;
import abdumalik.dev.clickup.model.Result;
import abdumalik.dev.clickup.model.Space;
import abdumalik.dev.clickup.repository.ProjectRepo;
import abdumalik.dev.clickup.repository.SpaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectService {

    @Autowired
    ProjectRepo repo;

    @Autowired
    SpaceRepo spaceRepo;

    public List<Project> getAllProjects() {
        return repo.findAll();
    }

    public Project getProjectById(UUID id) {
        return repo.findById(id).get();
    }

    public Project getProjectByName(String name) {
        return repo.findByName(name).get();
    }

    public Result create(ProjectDto dto) {
        boolean b = repo.existsByName(dto.getName());
        if (b) {
            return new Result("This project is already exist", false);
        }
        Project project = new Project();
        project.setName(dto.getName());
        project.setAccessType(dto.getAccessType());
        project.setArchived(dto.getArchived());
        project.setColor(dto.getColor());

        Optional<Space> byId = spaceRepo.findById(dto.getSpaceId());
        Space space = byId.get();
        project.setSpaceId(space);

        repo.save(project);
        return new Result("Successfully created project", true);
    }

    public Result update(ProjectDto dto, UUID id) {
        Optional<Project> byId = repo.findById(id);
        if (byId.isPresent()) {
            Project project = byId.get();
            project.setName(dto.getName());
            project.setAccessType(dto.getAccessType());
            project.setArchived(dto.getArchived());
            project.setColor(dto.getColor());

            Optional<Space> bySpaceId = spaceRepo.findById(dto.getSpaceId());
            Space space = bySpaceId.get();
            project.setSpaceId(space);

            repo.save(project);
            return new Result("Successfully updated project", true);
        }
        return new Result("Not found", false);
    }

    public Result delete(UUID id) {
        Optional<Project> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Successfully deleted project", true);
        }
        return new Result("Not found", false);
    }

}