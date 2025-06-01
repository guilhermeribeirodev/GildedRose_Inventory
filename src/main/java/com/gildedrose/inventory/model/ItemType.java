package com.gildedrose.inventory.model;

public enum ItemType {
    NORMAL_ITEM("Normal Item"),
    AGED_BRIE("Aged Brie"),
    SULFURAS("Sulfuras"),
    CONJURED("Conjured"),
    BACKSTAGE_PASSES("Backstage Passes");

    private final String displayName;

    ItemType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
