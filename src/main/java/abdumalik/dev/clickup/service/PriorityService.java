package abdumalik.dev.clickup.service;

import abdumalik.dev.clickup.dto.PriorityDto;
import abdumalik.dev.clickup.model.Icon;
import abdumalik.dev.clickup.model.Priority;
import abdumalik.dev.clickup.model.Result;
import abdumalik.dev.clickup.repository.IconRepo;
import abdumalik.dev.clickup.repository.PriorityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PriorityService {

    @Autowired
    PriorityRepo repo;

    @Autowired
    IconRepo iconRepo;

    public List<Priority> getAll() {
        return repo.findAll();
    }

    public Priority get(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(PriorityDto dto) {
        Priority priority = new Priority();
        priority.setName(dto.getName());

        Optional<Icon> byId = iconRepo.findById(dto.getIconId());
        Icon icon = byId.get();
        priority.setIconId(icon);

        repo.save(priority);
        return new Result("Priority information successfully created", true);
    }

    public Result update(PriorityDto dto, UUID id) {
        Optional<Priority> byId = repo.findById(id);
        if (byId.isPresent()) {
            Priority priority = byId.get();
            priority.setName(dto.getName());

            Optional<Icon> byIconId = iconRepo.findById(dto.getIconId());
            Icon icon = byIconId.get();
            priority.setIconId(icon);

            repo.save(priority);
            return new Result("Priority information successfully updated", true);
        }
        return new Result("Priority not found", false);
    }

    public Result delete(UUID id) {
        Optional<Priority> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Priority information successfully deleted", true);
        }
        return new Result("Priority not found", false);
    }

}