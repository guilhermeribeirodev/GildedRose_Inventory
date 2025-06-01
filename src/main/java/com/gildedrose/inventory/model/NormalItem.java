package com.gildedrose.inventory.model;

public class NormalItem extends Item implements Degreadeble, Expirable  {

    public NormalItem(String displayName, int sellIn, int quality, ItemType itemType) {
        super(displayName, sellIn, quality, itemType);
    }

    public NormalItem(Item item) {
        super(item.getDisplayName(), item.getSellIn(), item.getQuality(), item.getItemType());
    }

    @Override
    public Item degrade() {
        if(isExpired(getSellIn())){
            super.quality -= getDailyRate() * 2;
        }else{
            super.quality -= getDailyRate();
        }

        return  this;
    }

    @Override
    public boolean isExpired(int day) {
        return super.sellIn <= 0;
    }
}
