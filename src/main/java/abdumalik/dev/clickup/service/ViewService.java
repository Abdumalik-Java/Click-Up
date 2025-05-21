package abdumalik.dev.clickup.service;

import abdumalik.dev.clickup.dto.ViewDto;
import abdumalik.dev.clickup.model.Icon;
import abdumalik.dev.clickup.model.Result;
import abdumalik.dev.clickup.model.View;
import abdumalik.dev.clickup.repository.IconRepo;
import abdumalik.dev.clickup.repository.ViewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ViewService {

    @Autowired
    ViewRepo repo;

    @Autowired
    IconRepo iconRepo;

    public List<View> findAll() {
        return repo.findAll();
    }

    public View findById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(ViewDto dto) {
        View view = new View();
        view.setName(dto.getName());

        Optional<Icon> byId = iconRepo.findById(dto.getIconId());
        Icon icon = byId.get();
        view.setIconId(icon);

        repo.save(view);
        return new Result("View information successfully created", true);
    }

    public Result update(ViewDto dto, UUID id) {
        Optional<View> byId = repo.findById(id);
        if (byId.isPresent()) {
            View view = byId.get();
            view.setName(dto.getName());

            Optional<Icon> byId1 = iconRepo.findById(dto.getIconId());
            Icon icon = byId1.get();
            view.setIconId(icon);

            repo.save(view);
            return new Result("View information successfully updated", true);
        }
        return new Result("View information not found", false);
    }

    public Result delete(UUID id) {
        Optional<View> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("View information successfully deleted", true);
        }
        return new Result("View information not found", false);
    }

}