package com.example.clickup.service;

import com.example.clickup.dto.TimeTrackerDto;
import com.example.clickup.model.Result;
import com.example.clickup.model.Task;
import com.example.clickup.model.TimeTracker;
import com.example.clickup.repository.TaskRepo;
import com.example.clickup.repository.TimeTrackerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TimeTrackerService {

    @Autowired
    TimeTrackerRepo repo;

    @Autowired
    TaskRepo taskRepo;

    public List<TimeTracker> getAll() {
        return repo.findAll();
    }

    public TimeTracker getById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(TimeTrackerDto dto) {
        TimeTracker timeTracker = new TimeTracker();

        Optional<Task> byId = taskRepo.findById(dto.getTaskId());
        Task task = byId.get();
        timeTracker.setTaskId(task);

        repo.save(timeTracker);
        return new Result("TimeTracker information created successfully", true);
    }

    public Result update(TimeTrackerDto dto, UUID id) {
        Optional<TimeTracker> byId = repo.findById(id);
        if (byId.isPresent()) {
            TimeTracker timeTracker = byId.get();

            Optional<Task> byId1 = taskRepo.findById(dto.getTaskId());
            Task task = byId1.get();
            timeTracker.setTaskId(task);

            repo.save(timeTracker);
            return new Result("TimeTracker information updated successfully", true);
        }
        return new Result("TimeTracker information not found", false);
    }

    public Result delete(UUID id) {
        Optional<TimeTracker> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("TimeTracker information deleted successfully", true);
        }
        return new Result("TimeTracker information not found", false);
    }

}