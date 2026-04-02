package com.example.category.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.category.model.Category;
import com.example.category.service.CategoryService;
import com.example.category.service.UserClient;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @Autowired
    private UserClient userClient;
    
    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) {
         Category saved = service.create(category);
        return ResponseEntity.created(URI.create("/api/categories/" + saved.getId())).body(saved);
    }

    @GetMapping
    public List<Category> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Category getById(@PathVariable String id) { return service.getById(id); }

    @PutMapping("/{id}")
    public Category update(@PathVariable String id, @RequestBody Category category) { return service.update(id, category); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
