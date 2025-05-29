package com.gildedrose.inventory.model;

public class NormalItem extends Item implements Degreadeble, Expirable  {

    public NormalItem() {
    }

    public NormalItem(String displayName, int sellIn, int quality, ItemType itemType) {
        super(displayName, sellIn, quality, itemType);
    }

    @Override
    public void degrade(int amount) {
        super.quality -= amount;
    }

    @Override
    public boolean isExpired(int day) {
        return super.s;
    }
}
