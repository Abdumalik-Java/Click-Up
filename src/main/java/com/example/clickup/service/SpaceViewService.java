package com.example.clickup.service;

import com.example.clickup.dto.SpaceViewDto;
import com.example.clickup.model.Result;
import com.example.clickup.model.Space;
import com.example.clickup.model.SpaceView;
import com.example.clickup.model.View;
import com.example.clickup.repository.SpaceRepo;
import com.example.clickup.repository.SpaceViewRepo;
import com.example.clickup.repository.ViewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SpaceViewService {

    @Autowired
    SpaceViewRepo repo;

    @Autowired
    SpaceRepo spaceRepo;

    @Autowired
    ViewRepo viewRepo;

    public List<SpaceView> getAll() {
        return repo.findAll();
    }

    public SpaceView getById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(SpaceViewDto dto) {
        SpaceView spaceView = new SpaceView();

        Optional<Space> byId = spaceRepo.findById(dto.getSpaceId());
        Space space = byId.get();
        spaceView.setSpaceId((List<Space>) space);

        Optional<View> byId1 = viewRepo.findById(dto.getViewId());
        View view = byId1.get();
        spaceView.setViewId((List<View>) view);

        repo.save(spaceView);
        return new Result("SpaceView information created successfully", true);
    }

    public Result update(SpaceViewDto dto, UUID id) {
        Optional<SpaceView> byId = repo.findById(id);
        if (byId.isPresent()) {
            SpaceView spaceView = byId.get();

            Optional<Space> byId2 = spaceRepo.findById(dto.getSpaceId());
            Space space = byId2.get();
            spaceView.setSpaceId((List<Space>) space);

            Optional<View> byId1 = viewRepo.findById(dto.getViewId());
            View view = byId1.get();
            spaceView.setViewId((List<View>) view);

            repo.save(spaceView);
            return new Result("SpaceView information updated successfully", true);
        }
        return new Result("SpaceView information not found", false);
    }

    public Result delete(UUID id) {
        Optional<SpaceView> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("SpaceView information deleted successfully", true);
        }
        return new Result("SpaceView information not found", false);
    }

}