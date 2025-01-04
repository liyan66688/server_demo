package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return categoryService.findAllCategories();
    }

    @GetMapping("/categories/{cid}")
    @ResponseBody
    public Optional<Category> getCategory(@PathVariable Long cid) {
        return  categoryService.findOneCategory(cid);
    }

    @PostMapping("/categories")
    public long addCategory(@RequestParam String name) {
        // 模拟一个返回实体类
        Category c = new Category();
        c.setName(name);
        System.out.println("创建新的消费分类，分类名称是" + name);
        System.out.println("将数据存到数据库");
        Category x = categoryService.saveCategory(c);
        return x.getId();
    }

    @PutMapping("/categories/{cid}")
    public void updateCategory(@PathVariable Long cid, @RequestParam String name) {
        Category c = new Category();
        c.setName(name);
        c.setId(cid);
        categoryService.saveCategory(c);
    }

    @DeleteMapping("/categories/{cid}")
    public void deleteCategory(@PathVariable Long cid) {
        System.out.println("删除消费分类" + cid);
        Category c = new Category();
        c.setId(cid);
        categoryService.deleteOneCategory(c);
    }
}