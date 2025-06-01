package com.gildedrose.inventory.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.Objects;

//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
//@JsonSubTypes({@JsonSubTypes.Type(value = AgedBrie.class, name = "Aged Brie"),
//        @JsonSubTypes.Type(value = NormalItem.class, name = "Normal Item")})
public class Item implements Serializable {

    private String displayName;
    protected int sellIn;
    protected int quality;
    private ItemType itemType;
    private int dailyRate;

    public Item() {
    }

    public Item(String displayName, int sellIn, int quality, ItemType itemType) {
        this.displayName = displayName;
        this.sellIn = sellIn;
        this.quality = quality;
        this.itemType = itemType;
    }

    //  Getters
    public  String getDisplayName(){ return  displayName;}

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

    public void setDailyRate(int dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return sellIn == item.sellIn && quality == item.quality && dailyRate == item.dailyRate && Objects.equals(displayName, item.displayName) && itemType == item.itemType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, sellIn, quality, itemType, dailyRate);
    }
}