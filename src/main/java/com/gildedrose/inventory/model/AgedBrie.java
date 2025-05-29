package com.gildedrose.inventory.model;

public class AgedBrie extends Item implements Improvable  {

    public AgedBrie() {
    }

    public AgedBrie(String displayName, int sellIn, int quality, ItemType itemType) {
        super(displayName, sellIn, quality, itemType);
    }

    @Override
    public void improve(int amount) {
        super.quality += amount;
    }

}
