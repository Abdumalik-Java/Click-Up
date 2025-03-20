package com.example.clickup.service;

import com.example.clickup.dto.CheckListDto;
import com.example.clickup.model.CheckList;
import com.example.clickup.model.Result;
import com.example.clickup.model.Task;
import com.example.clickup.repository.CheckListRepo;
import com.example.clickup.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CheckListService {

    @Autowired
    CheckListRepo repo;

    @Autowired
    TaskRepo taskRepo;

    public List<CheckList> findAll() {
        return repo.findAll();
    }

    public CheckList findById(UUID id) {
        return repo.findById(id).get();
    }

    public CheckList findByName(String name) {
        return repo.findByName(name).get();
    }

    public Result create(CheckListDto dto) {
        CheckList checkList = new CheckList();
        checkList.setName(dto.getName());

        Optional<Task> byId = taskRepo.findById(dto.getTaskId());
        Task task = byId.get();
        checkList.setTaskId((List<Task>) task);

        repo.save(checkList);
        return new Result("Checklist information created successfully", true);
    }

    public Result update(CheckListDto dto, UUID id) {
        Optional<CheckList> byId = repo.findById(id);
        if (byId.isPresent()) {
            CheckList checkList = byId.get();
            checkList.setName(dto.getName());

            Optional<Task> byId1 = taskRepo.findById(dto.getTaskId());
            Task task = byId1.get();
            checkList.setTaskId((List<Task>) task);

            repo.save(checkList);
            return new Result("Checklist information updated successfully", true);
        }
        return new Result("Checklist information not found", false);
    }

    public Result delete(UUID id) {
        Optional<CheckList> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.deleteById(id);
            return new Result("Checklist information deleted successfully", true);
        }
        return new Result("Checklist information not found", false);
    }

}