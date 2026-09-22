package com.todoapp.service;


import com.todoapp.exception.InformationExistException;
import com.todoapp.model.Category;
import com.todoapp.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category createCategory(Category categoryObject){
        Category category = categoryRepository.findByName(categoryObject.getName());
        if(category != null) {
            throw new InformationExistException("Category with name " + category.getName() + " already exists");
        } else {
            return categoryRepository.save(categoryObject);
        }
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategory(Long id) {
        return categoryRepository.getReferenceById(id);
    }

}
