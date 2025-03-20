package com.example.clickup.service;

import com.example.clickup.dto.TaskDependencyDto;
import com.example.clickup.model.Result;
import com.example.clickup.model.Task;
import com.example.clickup.model.TaskDependency;
import com.example.clickup.repository.TaskDependencyRepo;
import com.example.clickup.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskDependencyService {

    @Autowired
    TaskDependencyRepo repo;

    @Autowired
    TaskRepo taskRepo;

    public List<TaskDependency> getAll() {
        return repo.findAll();
    }

    public TaskDependency getById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(TaskDependencyDto dto) {
        TaskDependency taskDependency = new TaskDependency();
        taskDependency.setDependencyTaskId(dto.getDependencyTaskId());

        Optional<Task> byId = taskRepo.findById(dto.getTaskId());
        Task task = byId.get();
        taskDependency.setTaskId(task);

        repo.save(taskDependency);
        return new Result("TaskDependency information created successfully", true);
    }

    public Result update(TaskDependencyDto dto, UUID id) {
        Optional<TaskDependency> byId = repo.findById(id);
        if (byId.isPresent()) {
            TaskDependency taskDependency = byId.get();
            taskDependency.setDependencyTaskId(dto.getDependencyTaskId());

            Optional<Task> byTaskId = taskRepo.findById(dto.getTaskId());
            Task task = byTaskId.get();
            taskDependency.setTaskId(task);

            repo.save(taskDependency);
            return new Result("TaskDependency information updated successfully", true);
        }
        return new Result("TaskDependency information not found", false);
    }

    public Result delete(UUID id) {
        Optional<TaskDependency> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("TaskDependency information deleted successfully", true);
        }
        return new Result("TaskDependency information not found", false);
    }

}