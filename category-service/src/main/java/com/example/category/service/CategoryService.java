package com.example.category.service;

import com.example.category.model.Category;
import java.util.List;

public interface CategoryService {
    Category create(Category category);
    Category update(String id, Category category);
    Category getById(String id);
    List<Category> getAll();
    void delete(String id);
}
