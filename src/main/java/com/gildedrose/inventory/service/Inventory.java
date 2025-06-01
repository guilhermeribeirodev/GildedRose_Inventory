package com.gildedrose.inventory.service;

import com.gildedrose.inventory.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Inventory {
    private List<Item> items = new ArrayList<>();
    Calendar date = Calendar.getInstance();

    public Inventory() {
    }

    public Inventory(List<Item> items) {
        this.items = items;
    }

    public void dayPasses(List<Item> items) {
        date.roll(Calendar.DATE, true);

        this.items.addAll(items);

        for (Item item : this.items) {
            int dailyRate = item.getItemType().getDailyRate();

            if (item instanceof Degreadeble) {
                if (((Expirable) item).isExpired(item.getSellIn())) {
                    dailyRate *= 2;
                }
                ((Degreadeble) item).degrade(dailyRate);

            } else if (item instanceof Improvable) {
                ((Improvable) item).improve(dailyRate);

            } else if (item instanceof Sulfuras) {
               // this.items.add(item);
                continue;

            } else if (item instanceof BackstagePasses) {
                ((BackstagePasses) item).applyRules();
                item.setSellIn(item.getSellIn() - 1);
               // this.items.add(item);
                continue;
            }

            item.setSellIn(item.getSellIn() - 1);
           // this.items.add(item);
        }
    }

    public List<Item> getItems() {
        return items;
    }
}
