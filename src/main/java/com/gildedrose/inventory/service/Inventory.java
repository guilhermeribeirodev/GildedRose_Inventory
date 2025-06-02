package com.gildedrose.inventory.service;

import com.gildedrose.inventory.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Inventory {

    Calendar date = Calendar.getInstance();

    public Inventory() {
    }

    public List<Item> dayPasses(List<Item> items) {
        date.roll(Calendar.DATE, true);

        List<Item> updatedList = new ArrayList<>();

        for (Item item : items) {

            Item returnItem = null;

            if (item instanceof Degreadeble) {
                returnItem = ((Degreadeble) item).degrade();
            } else if (item instanceof Improvable) {
                returnItem = ((Improvable) item).improve();
            } else if (item instanceof Sulfuras) {
                returnItem = item;
            } else if (item instanceof BackstagePasses) {
                returnItem = ((BackstagePasses) item).applyRules();
            }else {
                returnItem = new Item("NO SUCH ITEM",0,0,null);
            }

            updatedList.add(returnItem);
        }

        return updatedList;
    }

}
