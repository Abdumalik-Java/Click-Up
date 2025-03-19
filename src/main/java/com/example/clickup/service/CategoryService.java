package com.example.clickup.service;

import com.example.clickup.dto.CategoryDto;
import com.example.clickup.model.Category;
import com.example.clickup.model.Project;
import com.example.clickup.model.Result;
import com.example.clickup.repository.CategoryRepo;
import com.example.clickup.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo repo;

    @Autowired
    ProjectRepo projectRepo;

    public List<Category> getAllCategories() {
        return repo.findAll();
    }

    public Category getCategoryById(UUID id) {
        return repo.findById(id).get();
    }

    public Category getCategoryByName(String name) {
        return repo.findByName(name).get();
    }

    public Result create(CategoryDto dto) {
        boolean b = repo.existsByName(dto.getName());
        if (b) {
            return new Result("Category is already exist", false);
        }
        Category category = new Category();
        category.setName(dto.getName());
        category.setAccessType(dto.getAccessType());
        category.setArchived(dto.getArchived());
        category.setColor(dto.getColor());

        Optional<Project> byId = projectRepo.findById(dto.getProjectId());
        Project project = byId.get();
        category.setProjectId((List<Project>) project);

        repo.save(category);
        return new Result("Category information successfully created", true);
    }

    public Result update(CategoryDto dto, UUID id) {
        Optional<Category> byId = repo.findById(id);
        if (byId.isPresent()) {
            Category category = byId.get();
            category.setName(dto.getName());
            category.setAccessType(dto.getAccessType());
            category.setArchived(dto.getArchived());
            category.setColor(dto.getColor());

            Optional<Project> byProjectId = projectRepo.findById(dto.getProjectId());
            Project project = byProjectId.get();
            category.setProjectId((List<Project>) project);

            repo.save(category);
            return new Result("Category information successfully updated", true);
        }
        return new Result("Category not found", false);
    }

    public Result delete(UUID id) {
        Optional<Category> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Category information successfully deleted", true);
        }
        return new Result("Category not found", false);
    }

}