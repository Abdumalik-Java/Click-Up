package com.example.clickup.service;

import com.example.clickup.dto.IconDto;
import com.example.clickup.model.Attachment;
import com.example.clickup.model.Icon;
import com.example.clickup.model.Result;
import com.example.clickup.repository.AttachmentRepo;
import com.example.clickup.repository.IconRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class IconService {

    @Autowired
    IconRepo repo;

    @Autowired
    AttachmentRepo attachmentRepo;

    public List<Icon> getIcons() {
        return repo.findAll();
    }

    public Icon getIconById(UUID id) {
        return repo.findById(id).get();
    }

    public Result createIcon(IconDto iconDto) {
        Icon icon = new Icon();
        icon.setColor(iconDto.getColor());
        icon.setInitialLetter(iconDto.getInitialLetter());

        Optional<Attachment> byId = attachmentRepo.findById(iconDto.getAttachmentId());
        Attachment attachment = byId.get();
        icon.setAttachmentId(attachment);

        repo.save(icon);
        return new Result("Icon information created successfully", true);
    }

    public Result updateIcon(UUID id, IconDto iconDto) {
        Optional<Icon> byId = repo.findById(id);
        if (byId.isPresent()) {
            Icon icon = byId.get();
            icon.setColor(iconDto.getColor());
            icon.setInitialLetter(iconDto.getInitialLetter());

            Optional<Attachment> byId1 = attachmentRepo.findById(iconDto.getAttachmentId());
            Attachment attachment = byId1.get();
            icon.setAttachmentId(attachment);

            repo.save(icon);
            return new Result("Icon information updated successfully", true);
        }
        return new Result("Icon information not found", false);
    }

    public Result deleteIcon(UUID id) {
        Optional<Icon> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Icon information deleted successfully", true);
        }
        return new Result("Icon information not found", false);
    }

}