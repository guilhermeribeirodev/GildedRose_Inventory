package com.gildedrose.inventory.model;

import com.gildedrose.inventory.model.ItemType;

import java.io.Serializable;

public class Item implements Serializable {
    private  String displayName;
    protected   int sellIn;
    protected   int quality;
    private ItemType itemType;
    private  int dailyRate;

    public Item() {}

    public Item(String displayName, int sellIn, int quality, ItemType itemType) {
        this.displayName = displayName;
        this.sellIn = sellIn;
        this.quality = quality;
        this.itemType = itemType;
    }

    //  Getters
    public String getDisplayName() {
        return displayName;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public int getDailyRate() {
        return dailyRate;
    }

    // Setters
    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public void setDailyRate(int dailyRate) {
        this.dailyRate = dailyRate;
    }
}