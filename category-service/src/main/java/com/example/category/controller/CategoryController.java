package com.example.category.controller;

import com.example.category.model.Category;
import com.example.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

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
