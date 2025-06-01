package com.gildedrose.inventory.model;

public class ConjuredItem extends Item implements Degreadeble, Expirable{

    public ConjuredItem(String displayName, int sellIn, int quality, ItemType itemType) {
        super(displayName, sellIn, quality, itemType);
    }

    public ConjuredItem(Item item) {
        super(item.getDisplayName(), item.getSellIn(), item.getQuality(), item.getItemType());
    }

    @Override
    public void degrade(int amount) {
        super.quality -= amount;
    }

    @Override
    public boolean isExpired(int day) {
        return super.sellIn <= 0;
    }
}
