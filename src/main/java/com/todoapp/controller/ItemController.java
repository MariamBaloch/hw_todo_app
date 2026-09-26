package com.todoapp.controller;

import com.todoapp.model.Item;
import com.todoapp.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/api")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/categories/{categoryId}/items")
    public List<Item> getAllItems(@PathVariable Long categoryId) {
        return itemService.getAllItems(categoryId);
    }

    @PostMapping("/categories/{categoryId}/items")
    public Item createItem(
            @PathVariable Long categoryId,
            @RequestBody Item itemObject
    ) {
        return itemService.createItem(categoryId, itemObject);
    }

    @GetMapping("categories/{categoryId}/items/{itemId}")
    public Item getItem(
            @PathVariable Long categoryId,
            @PathVariable Long itemId) {
        return itemService.getItem(categoryId, itemId);
    }

    @PutMapping("/categories/{categoryId}/items/{itemId}")
    public Item updateItem(
            @PathVariable Long categoryId,
            @PathVariable Long itemId,
            @RequestBody Item itemObject
    ) {
        return itemService.updateItem(categoryId, itemId, itemObject);
    }

    @DeleteMapping("/categories/{categoryId}/items/{itemId}")
    public boolean deleteItem(
            @PathVariable Long categoryId,
            @PathVariable Long itemId
    ) {
        return itemService.deleteItem(categoryId, itemId);
    }
}