package com.example.clickup.service;

import com.example.clickup.dto.SpaceUserDto;
import com.example.clickup.model.Result;
import com.example.clickup.model.Space;
import com.example.clickup.model.SpaceUser;
import com.example.clickup.repository.SpaceRepo;
import com.example.clickup.repository.SpaceUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SpaceUserService {

    @Autowired
    SpaceUserRepo repo;

    @Autowired
    SpaceRepo spaceRepo;

    public List<SpaceUser> getAll() {
        return repo.findAll();
    }

    public SpaceUser getById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(SpaceUserDto dto) {
        SpaceUser spaceUser = new SpaceUser();
        spaceUser.setMemberId(dto.getMemberId());

        Optional<Space> byId = spaceRepo.findById(dto.getSpaceId());
        Space space = byId.get();
        spaceUser.setSpaceId((List<Space>) space);

        repo.save(spaceUser);
        return new Result("SpaceUser information created successfully", true);
    }

    public Result update(SpaceUserDto dto, UUID id) {
        Optional<SpaceUser> byId = repo.findById(id);
        if (byId.isPresent()) {
            SpaceUser spaceUser = byId.get();
            spaceUser.setMemberId(dto.getMemberId());

            Optional<Space> bySpaceId = spaceRepo.findById(dto.getSpaceId());
            Space space = bySpaceId.get();
            spaceUser.setSpaceId((List<Space>) space);

            repo.save(spaceUser);
            return new Result("SpaceUser information updated successfully", true);
        }
        return new Result("SpaceUser information not found", false);
    }

    public Result delete(UUID id) {
        Optional<SpaceUser> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("SpaceUser information deleted successfully", true);
        }
        return new Result("SpaceUser information not found", false);
    }

}