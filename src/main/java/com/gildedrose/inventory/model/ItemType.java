package com.gildedrose.inventory.model;

import com.gildedrose.inventory.AgeType;

import static com.gildedrose.inventory.AgeType.*;

public enum ItemType {
    NORMAL_ITEM("Normal Item",1, DEGRADE),
    AGED_BRIE("Aged Brie",1, IMPROVE),
    SULFURAS("Sulfuras", 0, NONE),
    CONJURED("Conjured", 2, DEGRADE),
    BACKSTAGE_PASSES("Backstage Passes",1, NONE);

    private final  String displayName;
    private final int dailyRate;
    public final AgeType ageType;

    ItemType(String displayName, int dailyRate, AgeType ageType) {
        this.displayName = displayName;
        this.dailyRate = dailyRate;
        this.ageType = ageType;
    }

    public  int getDailyRate(){
        return  dailyRate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public AgeType getAgeType() {
        return ageType;
    }
}
