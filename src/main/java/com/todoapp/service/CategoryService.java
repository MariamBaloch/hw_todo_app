package com.todoapp.service;


import com.todoapp.exception.InformationExistException;
import com.todoapp.exception.InformationNotFoundException;
import com.todoapp.model.Category;
import com.todoapp.model.User;
import com.todoapp.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserService userService;

    public Category createCategory(Category categoryObject){
        User user = userService.getCurrentLoggedInUser();
        Category category = categoryRepository.findByUserIdAndName(user.getId(), categoryObject.getName());
        if(category != null) {
            throw new InformationExistException("Category with name " + category.getName() + " already exists");
        } else {
            categoryObject.setUser(user);
            return categoryRepository.save(categoryObject);
        }
    }

    public List<Category> getCategories() {
        return categoryRepository.findAllByUserId(userService.getCurrentLoggedInUser().getId());
    }

    public Category getCategory(Long id) {
        return categoryRepository.findByIdAndUserId(id, userService.getCurrentLoggedInUser().getId())
                .orElseThrow(() -> new InformationNotFoundException("Category with id " + id + "does not exits"));
    }

    public Category updateCategory(Long id, Category updatedCategory) {
        Category category = getCategory(id);
        category.setName(updatedCategory.getName());
        category.setDescription(updatedCategory.getDescription());
        return categoryRepository.save(category);
    }

    public boolean deleteCategory(Long id) {
        Category category = getCategory(id);
        categoryRepository.delete(category);
        return true;
    }

}
