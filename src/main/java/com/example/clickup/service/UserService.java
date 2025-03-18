package com.example.clickup.service;

import com.example.clickup.dto.UserDto;
import com.example.clickup.model.Result;
import com.example.clickup.model.User;
import com.example.clickup.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepo repo;

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(UserDto dto) {
        boolean existsByEmail = repo.existsByEmail(dto.getEmail());
        if (existsByEmail) {
            return new Result("This email is already exist", false);
        }
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setColor(dto.getColor());
        user.setInitialLetter(dto.getInitialLetter());
        user.setAvatarId(dto.getAvatarId());
        repo.save(user);
        return new Result("User information created successfully", true);
    }

    public Result update(UserDto dto, UUID id) {
        Optional<User> byId = repo.findById(id);
        if (byId.isPresent()) {
            User user = byId.get();
            user.setFirstName(dto.getFirstName());
            user.setLastName(dto.getLastName());
            user.setEmail(dto.getEmail());
            user.setPassword(dto.getPassword());
            user.setColor(dto.getColor());
            user.setInitialLetter(dto.getInitialLetter());
            user.setAvatarId(dto.getAvatarId());
            repo.save(user);
            return new Result("User information updated successfully", true);
        }
        return new Result("User information not found", false);
    }

    public Result delete(UUID id) {
        Optional<User> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("User information deleted successfully", true);
        }
        return new Result("User information not found", false);
    }

}