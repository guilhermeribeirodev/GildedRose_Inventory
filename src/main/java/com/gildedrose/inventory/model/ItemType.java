package com.gildedrose.inventory.model;

import com.gildedrose.inventory.AgeType;

import static com.gildedrose.inventory.AgeType.*;

public enum ItemType {
    NORMAL_ITEM(1, DEGRADE),
    AGED_BRIE(1, IMPROVE),
    SULFURAS(0, NONE),
    CONJURED(2, DEGRADE),
    BACKSTAGE_PASSES(1, NONE);

    public final int dailyRate;
    public final AgeType ageType;

    ItemType(int dailyRate, AgeType ageType) {
        this.dailyRate = dailyRate;
        this.ageType = ageType;
    }
}
