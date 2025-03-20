package com.example.clickup.service;

import com.example.clickup.dto.TaskDto;
import com.example.clickup.model.*;
import com.example.clickup.repository.CategoryRepo;
import com.example.clickup.repository.PriorityRepo;
import com.example.clickup.repository.StatusRepo;
import com.example.clickup.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    TaskRepo repo;

    @Autowired
    StatusRepo statusRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    PriorityRepo priorityRepo;

    public List<Task> findAll() {
        return repo.findAll();
    }

    public Task findById(UUID id) {
        return repo.findById(id).get();
    }

    public Task findByName(String name) {
        return repo.findByName(name).get();
    }

    public Result create(TaskDto dto) {
        boolean b = repo.existsByName(dto.getName());
        if (b) {
            return new Result("This task name is already exists", false);
        }
        Task task = new Task();
        task.setName(dto.getName());
        task.setDescription(dto.getDescription());
        task.setParentTaskId(dto.getParentTaskId());

        Optional<Status> byId = statusRepo.findById(dto.getStatusId());
        Status status = byId.get();
        task.setStatusId(status);

        Optional<Category> byId1 = categoryRepo.findById(dto.getCategoryId());
        Category category = byId1.get();
        task.setCategoryId(category);

        Optional<Priority> byId2 = priorityRepo.findById(dto.getPriorityId());
        Priority priority = byId2.get();
        task.setPriorityId(priority);

        repo.save(task);
        return new Result("Task created successfully", true);
    }

    public Result update(TaskDto dto, UUID id) {
        Optional<Task> byId = repo.findById(id);
        if (byId.isPresent()) {
            Task task = byId.get();
            task.setName(dto.getName());
            task.setDescription(dto.getDescription());
            task.setParentTaskId(dto.getParentTaskId());

            Optional<Status> byId1 = statusRepo.findById(dto.getStatusId());
            Status status = byId1.get();
            task.setStatusId(status);

            Optional<Category> byId2 = categoryRepo.findById(dto.getCategoryId());
            Category category = byId2.get();
            task.setCategoryId(category);

            Optional<Priority> byId3 = priorityRepo.findById(dto.getPriorityId());
            Priority priority = byId3.get();
            task.setPriorityId(priority);

            repo.save(task);
            return new Result("Task updated successfully", true);
        }
        return new Result("Task not found", false);
    }

    public Result delete(UUID id) {
        Optional<Task> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Task deleted successfully", true);
        }
        return new Result("Task not found", false);
    }

}