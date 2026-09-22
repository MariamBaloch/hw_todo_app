package com.todoapp.controller;

import com.todoapp.model.Category;
import com.todoapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/api")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category categoryObject){
        return categoryService.createCategory(categoryObject);
    }

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/categories/{categoryId}")
    public Category getCategory(@PathVariable Long categoryId) {
        return categoryService.getCategory(categoryId);
    }
}
