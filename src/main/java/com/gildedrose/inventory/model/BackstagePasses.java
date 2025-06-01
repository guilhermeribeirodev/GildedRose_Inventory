package com.gildedrose.inventory.model;

public class BackstagePasses extends  Item implements  Customisable{
    public BackstagePasses(String displayName, int sellIn, int quality, ItemType itemType) {
        super(displayName, sellIn, quality, itemType);
    }

    public BackstagePasses(Item item) {
        super(item.getDisplayName(), item.getSellIn(), item.getQuality(), item.getItemType());
    }

    @Override
    public Item applyRules() {
        if (sellIn <= 10 && sellIn > 5) {
            setDailyRate(getDailyRate() * 2);
            setQuality(getQuality() + getDailyRate());
        } else if (sellIn <= 5 && sellIn > 0) {
            setDailyRate(getDailyRate() * 3);
            setQuality(getQuality() + getDailyRate());
        } else if (sellIn <= 0) {
            setQuality(0);
        }

        setSellIn(getSellIn() - 1);

        return this;
    }
}
