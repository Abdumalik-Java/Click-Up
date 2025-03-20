package com.example.clickup.controller;

import com.example.clickup.dto.ChecklistItemDto;
import com.example.clickup.model.CheckListItem;
import com.example.clickup.model.Result;
import com.example.clickup.service.CheckListItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/checkListItem")
public class CheckListItemController {

    @Autowired
    CheckListItemService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readAll() {
        List<CheckListItem> all = service.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readOne(@PathVariable UUID id) {
        CheckListItem byId = service.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readByName(@PathVariable String name) {
        CheckListItem byName = service.getByName(name);
        return new ResponseEntity<>(byName, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> create(@RequestBody ChecklistItemDto dto) {
        Result result = service.create(dto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody ChecklistItemDto dto) {
        Result update = service.update(dto, id);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        Result delete = service.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

}