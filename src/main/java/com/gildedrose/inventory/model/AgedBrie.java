package com.gildedrose.inventory.model;

public class AgedBrie extends Item implements Improvable {

    public AgedBrie(String displayName, int sellIn, int quality, ItemType itemType) {
        super(displayName, sellIn, quality, itemType);
    }

    public AgedBrie(Item item) {
        super(item.getDisplayName(), item.getSellIn(), item.getQuality(), item.getItemType());
    }

    @Override
    public Item improve() {
        super.quality += getDailyRate();
        setSellIn(getSellIn() - 1);
        return this;
    }

}
