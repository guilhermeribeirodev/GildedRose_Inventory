package com.gildedrose.inventory.controller;

import com.gildedrose.inventory.mapper.ItemsMapper;
import com.gildedrose.inventory.model.Item;
import com.gildedrose.inventory.service.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {

    private final Inventory inventory;
    private final ItemsMapper mapper;

    public ItemController(@Autowired Inventory inventory, @Autowired ItemsMapper mapper) {
        this.inventory = inventory;
        this.mapper = mapper;
    }

    @PostMapping("/items")
    public ResponseEntity<List<Item>> create(@RequestBody List<Item> items) {

        final List<Item> mappedItems = mapper.map(items);

        final List<Item> itemsResponse = inventory.dayPasses(mappedItems);

        return ResponseEntity.ok(itemsResponse);
    }
}
