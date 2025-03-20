package com.example.clickup.service;

import com.example.clickup.dto.CategoryUserDto;
import com.example.clickup.model.Category;
import com.example.clickup.model.CategoryUser;
import com.example.clickup.model.Result;
import com.example.clickup.model.User;
import com.example.clickup.repository.CategoryRepo;
import com.example.clickup.repository.CategoryUserRepo;
import com.example.clickup.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryUserService {

    @Autowired
    CategoryUserRepo repo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    UserRepo userRepo;

    public List<CategoryUser> findAll() {
        return repo.findAll();
    }

    public CategoryUser findById(UUID id) {
        return repo.findById(id).get();
    }

    public CategoryUser findByName(String name) {
        return repo.findByName(name).get();
    }

    public Result create(CategoryUserDto dto) {
        CategoryUser categoryUser = new CategoryUser();
        categoryUser.setName(dto.getName());

        Optional<Category> byId = categoryRepo.findById(dto.getCategoryId());
        Category category = byId.get();
        categoryUser.setCategoryId(category);

        Optional<User> byId1 = userRepo.findById(dto.getUserId());
        User user = byId1.get();
        categoryUser.setUserId(user);

        repo.save(categoryUser);
        return new Result("CategoryUser information created successfully", true);
    }

    public Result update(CategoryUserDto dto, UUID id) {
        Optional<CategoryUser> byId = repo.findById(id);
        if (byId.isPresent()) {
            CategoryUser categoryUser = byId.get();
            categoryUser.setName(dto.getName());

            Optional<Category> byCategoryId = categoryRepo.findById(dto.getCategoryId());
            Category category = byCategoryId.get();
            categoryUser.setCategoryId(category);

            Optional<User> byUserId1 = userRepo.findById(dto.getUserId());
            User user = byUserId1.get();
            categoryUser.setUserId(user);

            repo.save(categoryUser);
            return new Result("CategoryUser information updated successfully", true);
        }
        return new Result("CategoryUser information not found", false);
    }

    public Result delete(UUID id) {
        Optional<CategoryUser> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("CategoryUser information deleted successfully", true);
        }
        return new Result("CategoryUser information not found", false);
    }

}