package com.dsv.javalinux.controller;

import com.dsv.javalinux.model.ItemModel;
import com.dsv.javalinux.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "*")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // Add new item
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemModel addItem(@RequestBody ItemModel item) {
        return itemService.addItem(item);
    }

    // Get item by ID
    @GetMapping("/{id}")
    public ItemModel getItem(@PathVariable Long id) {
        return itemService.getItemById(id);
    }
}
