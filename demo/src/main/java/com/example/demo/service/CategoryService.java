package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.entity.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findOneCategory(long id) {
        return categoryRepository.findById(id);
    }

    public void deleteOneCategory(Category category) {
        categoryRepository.delete(category);
    }
}