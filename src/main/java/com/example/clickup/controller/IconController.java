package com.example.clickup.controller;

import com.example.clickup.dto.IconDto;
import com.example.clickup.model.Icon;
import com.example.clickup.model.Result;
import com.example.clickup.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/icon")
public class IconController {

    @Autowired
    IconService iconService;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readAll() {
        List<Icon> icons = iconService.getIcons();
        return new ResponseEntity<>(icons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readOne(@PathVariable UUID id) {
        Icon icon = iconService.getIconById(id);
        return new ResponseEntity<>(icon, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> create(@RequestBody IconDto iconDto) {
        Result icon = iconService.createIcon(iconDto);
        return new ResponseEntity<>(icon, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody IconDto iconDto) {
        Result icon = iconService.updateIcon(id, iconDto);
        return new ResponseEntity<>(icon, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        Result icon = iconService.deleteIcon(id);
        return new ResponseEntity<>(icon, HttpStatus.OK);
    }

}