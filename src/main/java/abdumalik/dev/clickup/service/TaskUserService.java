package abdumalik.dev.clickup.service;

import abdumalik.dev.clickup.dto.TaskUserDto;
import abdumalik.dev.clickup.model.Result;
import abdumalik.dev.clickup.model.Task;
import abdumalik.dev.clickup.model.TaskUser;
import abdumalik.dev.clickup.model.User;
import abdumalik.dev.clickup.repository.TaskRepo;
import abdumalik.dev.clickup.repository.TaskUserRepo;
import abdumalik.dev.clickup.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskUserService {

    @Autowired
    TaskUserRepo repo;

    @Autowired
    TaskRepo taskRepo;

    @Autowired
    UserRepo userRepo;

    public List<TaskUser> getAllTaskUsers() {
        return repo.findAll();
    }

    public TaskUser getTaskUserById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(TaskUserDto dto) {
        TaskUser taskUser = new TaskUser();

        Optional<Task> byId = taskRepo.findById(dto.getTaskId());
        Task task1 = byId.get();
        taskUser.setTaskId(task1);

        Optional<User> byUserId = userRepo.findById(dto.getUserId());
        User user1 = byUserId.get();
        taskUser.setUserId(user1);

        repo.save(taskUser);
        return new Result("Task created successfully", true);
    }

    public Result update(TaskUserDto dto, UUID id) {
        Optional<TaskUser> byId = repo.findById(id);
        if (byId.isPresent()) {
            TaskUser taskUser = byId.get();

            Optional<Task> byTaskId = taskRepo.findById(dto.getTaskId());
            Task task1 = byTaskId.get();
            taskUser.setTaskId(task1);

            Optional<User> byUserId = userRepo.findById(dto.getUserId());
            User user1 = byUserId.get();
            taskUser.setUserId(user1);

            repo.save(taskUser);
            return new Result("Task updated successfully", true);
        }
        return new Result("Task not found", false);
    }

    public Result delete(UUID id) {
        Optional<TaskUser> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Task deleted successfully", true);
        }
        return new Result("Task not found", false);
    }

}