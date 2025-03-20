package com.example.clickup.controller;

import com.example.clickup.dto.CategoryUserDto;
import com.example.clickup.model.CategoryUser;
import com.example.clickup.model.Result;
import com.example.clickup.service.CategoryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categoryUser")
public class CategoryUserController {

    @Autowired
    CategoryUserService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readAll() {
        List<CategoryUser> all = service.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readOne(@PathVariable UUID id) {
        CategoryUser byId = service.findById(id);
        return ResponseEntity.status(200).body(byId);
    }

    @GetMapping("/{name}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readByName(@PathVariable String name) {
        CategoryUser byName = service.findByName(name);
        return new ResponseEntity<>(byName, HttpStatus.OK);
    }


    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> create(@RequestBody CategoryUserDto categoryUserDto) {
        Result result = service.create(categoryUserDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody CategoryUserDto categoryUserDto) {
        Result update = service.update(categoryUserDto, id);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        Result delete = service.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

}