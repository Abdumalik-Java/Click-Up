package com.example.clickup.service;

import com.example.clickup.dto.AttachmentDto;
import com.example.clickup.model.Attachment;
import com.example.clickup.model.Result;
import com.example.clickup.repository.AttachmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AttachmentService {

    @Autowired
    AttachmentRepo repo;

    public List<Attachment> getAll() {
        return repo.findAll();
    }

    public Attachment getById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(AttachmentDto attachmentDto) {
        Attachment attachment = new Attachment();
        attachment.setName(attachmentDto.getName());
        attachment.setOriginalName(attachmentDto.getOriginalName());
        attachment.setSize(attachmentDto.getSize());
        attachment.setContentType(attachmentDto.getContentType());
        repo.save(attachment);
        return new Result("Attachment information created successfully", true);
    }

    public Result update(UUID id, AttachmentDto attachmentDto) {
        Optional<Attachment> byId = repo.findById(id);
        if (byId.isPresent()) {
            Attachment attachment = byId.get();
            attachment.setName(attachmentDto.getName());
            attachment.setOriginalName(attachmentDto.getOriginalName());
            attachment.setSize(attachmentDto.getSize());
            attachment.setContentType(attachmentDto.getContentType());
            repo.save(attachment);
            return new Result("Attachment information updated successfully", true);
        }
        return new Result("Attachment information not found", false);
    }

    public Result delete(UUID id) {
        Optional<Attachment> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Attachment information deleted successfully", true);
        }
        return new Result("Attachment information not found", false);
    }

}