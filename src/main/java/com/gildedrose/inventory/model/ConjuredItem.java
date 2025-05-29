package com.gildedrose.inventory.model;

public class ConjuredItem extends Item implements Degreadeble{

    public ConjuredItem(String displayName, int sellIn, int quality, ItemType itemType) {
        super(displayName, sellIn, quality, itemType);
    }

    @Override
    public void degrade(int amount) {
        super.quality -= amount;
    }
}
