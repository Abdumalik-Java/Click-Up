package com.example.clickup.controller;

import com.example.clickup.dto.CommentDto;
import com.example.clickup.model.Comment;
import com.example.clickup.model.Result;
import com.example.clickup.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readAll() {
        List<Comment> comments = service.getComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN', 'USER')")
    public HttpEntity<?> readOne(@PathVariable UUID id) {
        Comment comment = service.getCommentById(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> create(@RequestBody CommentDto commentDto) {
        Result result = service.create(commentDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody CommentDto commentDto) {
        Result update = service.update(commentDto, id);
        return ResponseEntity.status(200).body(update);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        Result delete = service.delete(id);
        return ResponseEntity.status(200).body(delete);
    }

}