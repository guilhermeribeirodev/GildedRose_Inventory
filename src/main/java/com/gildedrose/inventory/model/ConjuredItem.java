package com.gildedrose.inventory.model;

public class ConjuredItem extends Item implements Degreadeble, Expirable{

    public ConjuredItem(String displayName, int sellIn, int quality, ItemType itemType) {
        super(displayName, sellIn, quality, itemType);
    }

    public ConjuredItem(Item item) {
        super(item.getDisplayName(), item.getSellIn(), item.getQuality(), item.getItemType());
    }

    @Override
    public Item degrade() {
        setDailyRate(getDailyRate() * 2);
        if(isExpired(sellIn)){
            super.quality -= getDailyRate() * 2;
        }else {
            super.quality -= getDailyRate();
        }

        setSellIn(getSellIn() - 1);

        return this;
    }

    @Override
    public boolean isExpired(int day) {
        return super.sellIn <= 0;
    }
}
