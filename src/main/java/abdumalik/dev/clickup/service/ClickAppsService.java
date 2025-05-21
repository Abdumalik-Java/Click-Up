package abdumalik.dev.clickup.service;

import abdumalik.dev.clickup.dto.ClickAppsDto;
import abdumalik.dev.clickup.model.ClickApps;
import abdumalik.dev.clickup.model.Icon;
import abdumalik.dev.clickup.model.Result;
import abdumalik.dev.clickup.repository.ClickAppsRepo;
import abdumalik.dev.clickup.repository.IconRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClickAppsService {

    @Autowired
    ClickAppsRepo repo;

    @Autowired
    IconRepo iconRepo;

    public List<ClickApps> getClickApps() {
        return repo.findAll();
    }

    public ClickApps getClickApps(UUID id) {
        return repo.findById(id).get();
    }

    public ClickApps getClickAppsByName(String name) {
        return repo.findByName(name).get();
    }

    public Result create(ClickAppsDto dto) {
        ClickApps clickApps = new ClickApps();
        clickApps.setName(dto.getName());

        Optional<Icon> byId = iconRepo.findById(dto.getIconId());
        Icon icon = byId.get();
        clickApps.setIconId(icon);

        repo.save(clickApps);
        return new Result("ClickApps information created successfully", true);
    }

    public Result update(ClickAppsDto dto, UUID id) {
        Optional<ClickApps> byId = repo.findById(id);
        if (byId.isPresent()) {
            ClickApps clickApps = byId.get();
            clickApps.setName(dto.getName());

            Optional<Icon> byId1 = iconRepo.findById(dto.getIconId());
            Icon icon = byId1.get();
            clickApps.setIconId(icon);

            repo.save(clickApps);
            return new Result("ClickApps information updated successfully", true);
        }
        return new Result("ClickApps information not found", false);
    }

    public Result delete(UUID id) {
        Optional<ClickApps> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("ClickApps information deleted successfully", true);
        }
        return new Result("ClickApps information not found", false);
    }

}