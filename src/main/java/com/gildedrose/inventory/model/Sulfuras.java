package com.gildedrose.inventory.model;

public class Sulfuras extends Item{

    public Sulfuras(String displayName, int sellIn, int quality, ItemType itemType) {
        super(displayName, sellIn, quality, itemType);
    }
    public Sulfuras(Item item) {
        super(item.getDisplayName(), item.getSellIn(), item.getQuality(), item.getItemType());
    }
}
