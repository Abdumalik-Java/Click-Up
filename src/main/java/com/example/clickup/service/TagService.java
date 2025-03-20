package com.example.clickup.service;

import com.example.clickup.dto.TagDto;
import com.example.clickup.model.Result;
import com.example.clickup.model.Tag;
import com.example.clickup.model.Workspace;
import com.example.clickup.repository.TagRepo;
import com.example.clickup.repository.WorkspaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TagService {

    @Autowired
    TagRepo repo;

    @Autowired
    WorkspaceRepo workspaceRepo;

    public List<Tag> getTags() {
        return repo.findAll();
    }

    public Tag getTag(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(TagDto dto) {
        Tag tag = new Tag();
        tag.setName(dto.getName());
        tag.setColor(dto.getColor());

        Optional<Workspace> byId = workspaceRepo.findById(dto.getWorkspaceId());
        Workspace workspace = byId.get();
        tag.setWorkspaceId(workspace);

        repo.save(tag);
        return new Result("Tag information created successfully", true);
    }

    public Result update(TagDto dto, UUID id) {
        Optional<Tag> byId = repo.findById(id);
        if (byId.isPresent()) {
            Tag tag = byId.get();
            tag.setName(dto.getName());
            tag.setColor(dto.getColor());

            Optional<Workspace> byId1 = workspaceRepo.findById(dto.getWorkspaceId());
            Workspace workspace = byId1.get();
            tag.setWorkspaceId(workspace);

            repo.save(tag);
            return new Result("Tag information updated successfully", true);
        }
        return new Result("Tag information not found", false);
    }

    public Result delete(UUID id) {
        Optional<Tag> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Tag information deleted successfully", true);
        }
        return new Result("Tag information not found", false);
    }

}