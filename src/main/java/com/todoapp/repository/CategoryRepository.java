package com.todoapp.repository;

import com.todoapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByUserIdAndName(Long userId, String categoryName);

    Optional<Category> findByIdAndUserId(Long categoryId, Long userId);

    List<Category> findAllByUserId(Long userId);
}
