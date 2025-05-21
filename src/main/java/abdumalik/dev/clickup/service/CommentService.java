package abdumalik.dev.clickup.service;

import abdumalik.dev.clickup.dto.CommentDto;
import abdumalik.dev.clickup.model.Comment;
import abdumalik.dev.clickup.model.Result;
import abdumalik.dev.clickup.model.Task;
import abdumalik.dev.clickup.repository.CommentRepo;
import abdumalik.dev.clickup.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommentService {

    @Autowired
    CommentRepo repo;

    @Autowired
    TaskRepo taskRepo;

    public List<Comment> getComments() {
        return repo.findAll();
    }

    public Comment getCommentById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(CommentDto dto) {
        Comment comment = new Comment();
        comment.setText(dto.getText());

        Optional<Task> byId = taskRepo.findById(dto.getTaskId());
        Task task = byId.get();
        comment.setTaskId(task);

        repo.save(comment);
        return new Result("Comment successfully created", true);
    }

    public Result update(CommentDto dto, UUID id) {
        Optional<Comment> byId = repo.findById(id);
        if (byId.isPresent()) {
            Comment comment = byId.get();
            comment.setText(dto.getText());

            Optional<Task> byId1 = taskRepo.findById(dto.getTaskId());
            Task task = byId1.get();
            comment.setTaskId(task);

            repo.save(comment);
            return new Result("Comment successfully updated", true);
        }
        return new Result("Comment not found", false);
    }

    public Result delete(UUID id) {
        Optional<Comment> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Comment successfully deleted", true);
        }
        return new Result("Comment not found", false);
    }

}