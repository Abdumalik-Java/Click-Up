package com.example.clickup.service;

import com.example.clickup.dto.StatusDto;
import com.example.clickup.model.*;
import com.example.clickup.repository.CategoryRepo;
import com.example.clickup.repository.ProjectRepo;
import com.example.clickup.repository.SpaceRepo;
import com.example.clickup.repository.StatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StatusService {

    @Autowired
    StatusRepo repo;

    @Autowired
    SpaceRepo spaceRepo;

    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    CategoryRepo categoryRepo;

    public List<Status> findAll() {
        return repo.findAll();
    }

    public Status findById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(StatusDto dto) {
        Status status = new Status();
        status.setName(dto.getName());
        status.setColor(dto.getColor());

        Optional<Space> byId = spaceRepo.findById(dto.getSpaceId());
        Space space = byId.get();
        status.setSpaceId((List<Space>) space);

        Optional<Project> byProjectId = projectRepo.findById(dto.getProjectId());
        Project project = byProjectId.get();
        status.setProjectId(project);

        Optional<Category> byCategoryId = categoryRepo.findById(dto.getCategoryId());
        Category category = byCategoryId.get();
        status.setCategoryId(category);

        repo.save(status);
        return new Result("Status information created successfully", true);
    }

    public Result update(StatusDto dto, UUID id) {
        Optional<Status> byId = repo.findById(id);
        if (byId.isPresent()) {
            Status status = byId.get();
            status.setName(dto.getName());
            status.setColor(dto.getColor());

            Optional<Space> bySpaceId = spaceRepo.findById(dto.getSpaceId());
            Space space = bySpaceId.get();
            status.setSpaceId((List<Space>) space);

            Optional<Project> byProjectId = projectRepo.findById(dto.getProjectId());
            Project project = byProjectId.get();
            status.setProjectId(project);

            Optional<Category> byCategoryId = categoryRepo.findById(dto.getCategoryId());
            Category category = byCategoryId.get();
            status.setCategoryId(category);

            repo.save(status);
            return new Result("Status information updated successfully", true);
        }
        return new Result("Status information not found", false);
    }

    public Result delete(UUID id) {
        Optional<Status> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Status information deleted successfully", true);
        }
        return new Result("Status information not found", false);
    }

}