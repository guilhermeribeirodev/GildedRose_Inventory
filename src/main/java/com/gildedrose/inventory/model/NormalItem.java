package com.gildedrose.inventory.model;

public class NormalItem extends Item implements Degreadeble, Expirable  {

    public NormalItem(String displayName, int sellIn, int quality, ItemType itemType) {
        super(displayName, sellIn, quality, itemType);
    }

    public NormalItem(Item item) {
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
