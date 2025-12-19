package com.example.category.service.impl;

import com.example.category.model.Category;
import com.example.category.repository.CategoryRepository;
import com.example.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repo;

    @Override
    public Category create(Category category) {
        return repo.save(category);
    }

    @Override
    public Category update(String id, Category category) {
        Category existing = getById(id);
        existing.setName(category.getName());
        existing.setDescription(category.getDescription());
        existing.setActive(category.isActive());
        return repo.save(existing);
    }

    @Override
    public Category getById(String id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Category not found: " + id));
    }

    @Override
    public List<Category> getAll() {
        return repo.findAll();
    }

    @Override
    public void delete(String id) {
        repo.deleteById(id);
    }
}
