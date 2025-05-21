package abdumalik.dev.clickup.service;

import abdumalik.dev.clickup.dto.TaskHistoryDto;
import abdumalik.dev.clickup.model.Result;
import abdumalik.dev.clickup.model.Task;
import abdumalik.dev.clickup.model.TaskHistory;
import abdumalik.dev.clickup.repository.TaskHistoryRepo;
import abdumalik.dev.clickup.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskHistoryService {

    @Autowired
    TaskHistoryRepo repo;

    @Autowired
    TaskRepo taskRepo;

    public List<TaskHistory> getAllTaskHistory() {
        return repo.findAll();
    }

    public TaskHistory getTaskHistoryById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(TaskHistoryDto dto) {
        TaskHistory taskHistory = new TaskHistory();
        taskHistory.setChangeFieldName(dto.getChangeFieldName());
        taskHistory.setBefore(dto.getBefore());
        taskHistory.setAfter(dto.getAfter());
        taskHistory.setData(dto.getData());

        Optional<Task> byId = taskRepo.findById(dto.getTaskId());
        Task task = byId.get();
        taskHistory.setTask(task);

        repo.save(taskHistory);
        return new Result("TaskHistory created successfully", true);
    }

    public Result update(TaskHistoryDto dto, UUID id) {
        Optional<TaskHistory> byId = repo.findById(id);
        if (byId.isPresent()) {
            TaskHistory taskHistory = byId.get();
            taskHistory.setChangeFieldName(dto.getChangeFieldName());
            taskHistory.setBefore(dto.getBefore());
            taskHistory.setAfter(dto.getAfter());
            taskHistory.setData(dto.getData());

            Optional<Task> byTaskId = taskRepo.findById(dto.getTaskId());
            Task task = byTaskId.get();
            taskHistory.setTask(task);

            repo.save(taskHistory);
            return new Result("TaskHistory updated successfully", true);
        }
        return new Result("TaskHistory not found", false);
    }

    public Result delete(UUID id) {
        Optional<TaskHistory> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("TaskHistory deleted successfully", true);
        }
        return new Result("TaskHistory not found", false);
    }

}