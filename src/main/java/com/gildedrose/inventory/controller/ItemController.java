package com.gildedrose.inventory.controller;

import com.gildedrose.inventory.model.*;
import com.gildedrose.inventory.service.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.gildedrose.inventory.model.ItemType.*;

@RestController
public class ItemController {

    private final Inventory inventory;

    public ItemController(@Autowired Inventory inventory) {
        this.inventory = inventory;
    }

    @PostMapping("/items")
    public ResponseEntity<List<Item>> create(@RequestBody List<Item> items) {

        List<Item> mappedItems = new ArrayList<>();

        for(Item item : items){
            if(item.getDisplayName().matches(AGED_BRIE.getDisplayName())) {
                mappedItems.add(new AgedBrie(item));
            }else if(item.getDisplayName().matches(NORMAL_ITEM.getDisplayName())){
                mappedItems.add(new NormalItem(item));
            }else if(item.getDisplayName().matches(CONJURED.getDisplayName())){
                mappedItems.add(new ConjuredItem(item));
            }else if(item.getDisplayName().matches(SULFURAS.getDisplayName())){
                mappedItems.add(new Sulfuras(item));
            }else if(item.getDisplayName().matches(BACKSTAGE_PASSES.getDisplayName())){
                mappedItems.add(new BackstagePasses(item));
            }
        }

        List<Item> itemsResponse = inventory.dayPasses(mappedItems);

        return ResponseEntity.ok(itemsResponse);
    }
}
