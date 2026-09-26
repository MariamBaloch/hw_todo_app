package com.todoapp.service;

import com.todoapp.exception.InformationNotFoundException;
import com.todoapp.model.Category;
import com.todoapp.model.Item;
import com.todoapp.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final CategoryService categoryService;

    public List<Item> getAllItems(Long categoryId) {
        Category category = categoryService.getCategory(categoryId);
        return itemRepository.getAllByCategory(category);
    }

    public Item createItem(Long categoryId, Item Item) {
        Category category = categoryService.getCategory(categoryId);
        Item.setCategory(category);
        return itemRepository.save(Item);
    }

    public Item getItem(Long categoryId, Long itemId) {
        Category category = categoryService.getCategory(categoryId);
        return itemRepository.findByIdAndCategory(itemId, category)
                .orElseThrow(() -> new InformationNotFoundException("Item with id " + itemId + " does not exist"));
    }

    public Item updateItem(Long categoryId, Long itemId, Item itemObject) {
        Item item = getItem(categoryId, itemId);
        item.setName(itemObject.getName());
        item.setDescription(itemObject.getDescription());
        return itemRepository.save(item);
    }

    public boolean deleteItem(Long categoryId, Long itemId) {
        Item item = getItem(categoryId, itemId);
        itemRepository.delete(item);
        return true;
    }

}