package com.example.clickup.controller;

import com.example.clickup.dto.CheckListDto;
import com.example.clickup.model.CheckList;
import com.example.clickup.model.Result;
import com.example.clickup.service.CheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/checklist")
public class ChecklistController {

    @Autowired
    CheckListService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readAll() {
        List<CheckList> all = service.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readOne(@PathVariable UUID id) {
        CheckList byId = service.findById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readByName(@PathVariable String name) {
        CheckList byName = service.findByName(name);
        return new ResponseEntity<>(byName, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> create(@RequestBody CheckListDto dto) {
        Result result = service.create(dto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody CheckListDto dto) {
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