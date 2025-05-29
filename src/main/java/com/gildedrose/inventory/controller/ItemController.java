package com.gildedrose.inventory.controller;

import com.gildedrose.inventory.Inventory;
import com.gildedrose.inventory.Item;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @PostMapping("/items")
    List<Item> create(@RequestBody List<Item> items){

        Inventory inventory = new Inventory(items);

        inventory.dayPasses();

        return  inventory.getItems();
    }
}
