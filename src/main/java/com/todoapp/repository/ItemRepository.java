package com.todoapp.repository;

import com.todoapp.model.Category;
import com.todoapp.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> getAllByCategory(Category category);

    Optional<Item> findByIdAndCategory(Long itemId, Category category);
}