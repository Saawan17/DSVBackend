package com.dsv.javalinux.service;

import com.dsv.javalinux.exception.ItemNotFoundException;
import com.dsv.javalinux.model.ItemModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ItemService {

    private final List<ItemModel> items = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public ItemModel addItem(ItemModel item) {
        item.setId(idCounter.getAndIncrement());
        items.add(item);
        return item;
    }

    public ItemModel getItemById(Long id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Item not found with id " + id));
    }
}
