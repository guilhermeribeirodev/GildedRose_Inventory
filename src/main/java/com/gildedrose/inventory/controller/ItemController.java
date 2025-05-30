package com.gildedrose.inventory.controller;

import com.gildedrose.inventory.Inventory;
import com.gildedrose.inventory.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    private final Inventory inventory;

    public ItemController(@Autowired Inventory inventory) {
        this.inventory = inventory;
    }

    @PostMapping("/items")
    public ResponseEntity<List<Item>> create(@RequestBody Item[] items) {

        Inventory inventory = new Inventory(List.of(items));
        inventory.dayPasses();

        return ResponseEntity.ok(inventory.getItems());
    }
}
