package abdumalik.dev.clickup.service;

import abdumalik.dev.clickup.dto.ChecklistItemDto;
import abdumalik.dev.clickup.model.CheckList;
import abdumalik.dev.clickup.model.CheckListItem;
import abdumalik.dev.clickup.model.Result;
import abdumalik.dev.clickup.model.User;
import abdumalik.dev.clickup.repository.CheckListRepo;
import abdumalik.dev.clickup.repository.ChecklistItemRepo;
import abdumalik.dev.clickup.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CheckListItemService {

    @Autowired
    ChecklistItemRepo repo;

    @Autowired
    CheckListRepo checklistRepo;

    @Autowired
    UserRepo userRepo;

    public List<CheckListItem> getAll() {
        return repo.findAll();
    }

    public CheckListItem getById(UUID id) {
        return repo.findById(id).get();
    }

    public CheckListItem getByName(String name) {
        return repo.findByName(name).get();
    }

    public Result create(ChecklistItemDto dto) {
        CheckListItem item = new CheckListItem();
        item.setName(dto.getName());
        item.setResolved(dto.getResolved());

        Optional<CheckList> byId = checklistRepo.findById(dto.getChecklistId());
        CheckList checkList = byId.get();
        item.setCheckListId(checkList);

        Optional<User> byId1 = userRepo.findById(dto.getAssignedUserId());
        User assignedUser = byId1.get();
        item.setAssignedUserId(assignedUser);

        repo.save(item);
        return new Result("CheckListItem info created successfully", true);
    }

    public Result update(ChecklistItemDto dto, UUID id) {
        Optional<CheckListItem> byId = repo.findById(id);
        if (byId.isPresent()) {
            CheckListItem item = byId.get();
            item.setName(dto.getName());
            item.setResolved(dto.getResolved());

            Optional<CheckList> byId1 = checklistRepo.findById(dto.getChecklistId());
            CheckList checkList = byId1.get();
            item.setCheckListId(checkList);

            Optional<User> byId2 = userRepo.findById(dto.getAssignedUserId());
            User assignedUser = byId2.get();
            item.setAssignedUserId(assignedUser);

            repo.save(item);
            return new Result("CheckListItem info updated successfully", true);
        }
        return new Result("CheckListItem info not found", false);
    }

    public Result delete(UUID id) {
        Optional<CheckListItem> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("CheckListItem info deleted successfully", true);
        }
        return new Result("CheckListItem info not found", false);
    }

}