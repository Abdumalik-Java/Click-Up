package com.example.clickup.service;

import com.example.clickup.dto.SpaceClickAppsDto;
import com.example.clickup.model.ClickApps;
import com.example.clickup.model.Result;
import com.example.clickup.model.Space;
import com.example.clickup.model.SpaceClickApps;
import com.example.clickup.repository.ClickAppsRepo;
import com.example.clickup.repository.SpaceClickAppsRepo;
import com.example.clickup.repository.SpaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SpaceClickAppsService {

    @Autowired
    SpaceClickAppsRepo repo;

    @Autowired
    SpaceRepo spaceRepo;

    @Autowired
    ClickAppsRepo clickAppsRepo;

    public List<SpaceClickApps> getAll() {
        return repo.findAll();
    }

    public SpaceClickApps getById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(SpaceClickAppsDto spaceClickAppsDto) {
        SpaceClickApps spaceClickApps = new SpaceClickApps();

        Optional<Space> byId = spaceRepo.findById(spaceClickAppsDto.getSpaceId());
        Space space = byId.get();
        spaceClickApps.setSpaceId((List<Space>) space);

        Optional<ClickApps> byId1 = clickAppsRepo.findById(spaceClickAppsDto.getClickAppId());
        ClickApps clickApps = byId1.get();
        spaceClickApps.setClickAppId(clickApps);

        repo.save(spaceClickApps);
        return new Result("SpaceClickApps information created successfully", true);
    }

    public Result update(SpaceClickAppsDto spaceClickAppsDto, UUID id) {
        Optional<SpaceClickApps> byId = repo.findById(id);
        if (byId.isPresent()) {
            SpaceClickApps spaceClickApps = byId.get();

            Optional<Space> byId1 = spaceRepo.findById(spaceClickAppsDto.getSpaceId());
            Space space = byId1.get();
            spaceClickApps.setSpaceId((List<Space>) space);

            Optional<ClickApps> byId2 = clickAppsRepo.findById(spaceClickAppsDto.getClickAppId());
            ClickApps clickApps = byId2.get();
            spaceClickApps.setClickAppId(clickApps);

            repo.save(spaceClickApps);
            return new Result("SpaceClickApps information updated successfully", true);
        }
        return new Result("SpaceClickApps information not found", false);
    }

    public Result delete(UUID id) {
        Optional<SpaceClickApps> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("SpaceClickApps information deleted successfully", true);
        }
        return new Result("SpaceClickApps information not found", false);
    }

}