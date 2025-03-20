package com.example.clickup.service;

import com.example.clickup.dto.TaskAttachmentDto;
import com.example.clickup.model.Attachment;
import com.example.clickup.model.Result;
import com.example.clickup.model.Task;
import com.example.clickup.model.TaskAttachment;
import com.example.clickup.repository.AttachmentRepo;
import com.example.clickup.repository.TaskAttachmentRepo;
import com.example.clickup.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskAttachmentService {

    @Autowired
    TaskAttachmentRepo repo;

    @Autowired
    TaskRepo taskRepo;

    @Autowired
    AttachmentRepo attachmentRepo;

    public List<TaskAttachment> getAll() {
        return repo.findAll();
    }

    public TaskAttachment getById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(TaskAttachmentDto dto) {
        TaskAttachment attachment = new TaskAttachment();
        attachment.setPinCoverImage(dto.getPinCoverImage());

        Optional<Task> byId = taskRepo.findById(dto.getTaskId());
        Task task = byId.get();
        attachment.setTaskId((List<Task>) task);

        Optional<Attachment> byId1 = attachmentRepo.findById(dto.getAttachmentId());
        Attachment attachment1 = byId1.get();
        attachment.setAttachmentId((List<Attachment>) attachment1);

        repo.save(attachment);
        return new Result("TaskAttachment created successfully", true);
    }

    public Result update(TaskAttachmentDto dto, UUID id) {
        Optional<TaskAttachment> byId = repo.findById(id);
        if (byId.isPresent()) {
            TaskAttachment attachment = byId.get();
            attachment.setPinCoverImage(dto.getPinCoverImage());

            Optional<Task> byId1 = taskRepo.findById(dto.getTaskId());
            Task task = byId1.get();
            attachment.setTaskId((List<Task>) task);

            Optional<Attachment> byId2 = attachmentRepo.findById(dto.getAttachmentId());
            Attachment attachment2 = byId2.get();
            attachment.setAttachmentId((List<Attachment>) attachment2);

            repo.save(attachment);
            return new Result("TaskAttachment updated successfully", true);
        }
        return new Result("TaskAttachment not found", false);
    }

    public Result delete(UUID id) {
        Optional<TaskAttachment> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("TaskAttachment deleted successfully", true);
        }
        return new Result("TaskAttachment not found", false);
    }

}