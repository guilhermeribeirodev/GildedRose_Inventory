package com.gildedrose.inventory;

import java.util.*;

public class Inventory {
    private List<Item> items = new ArrayList<>();
    Calendar date = Calendar.getInstance();

    public Inventory() {
    }

    public Inventory(List<Item> items ) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void dayPasses() {
        date.roll(Calendar.DATE, true);

        for(Item item : items){

            if(item.getItemType() == ItemType.BACKSTAGE_PASSES){
                if(item.getSellIn() <= 10 && item.getSellIn() > 5){
                    item.setDailyRate(item.getItemType().dailyRate * 2);
                    item.setQuality(item.getQuality() + item.getDailyRate());
                }else if(item.getSellIn() <= 5 && item.getSellIn() > 0){
                    item.setDailyRate(item.getItemType().dailyRate * 3);
                    item.setQuality(item.getQuality() + item.getDailyRate());
                }else if(item.getSellIn() <= 0){
                    item.setQuality(0);
                }
                item.setSellIn(item.getSellIn() - 1);
                continue;
            }

            if(item.getSellIn()  < 1){
               item.setDailyRate(item.getItemType().dailyRate * 2);
            }else{
                item.setDailyRate(item.getItemType().dailyRate);
            }

            if(item.getItemType().ageType == AgeType.IMPROVE){
               item.setQuality(item.getQuality() + item.getDailyRate());
               item.setSellIn(item.getSellIn() - 1);
            }else if(item.getItemType().ageType == AgeType.DEGRADE){
                item.setQuality(item.getQuality() - item.getDailyRate());
                item.setSellIn(item.getSellIn() - 1);
            }
        }
    }

    public  List<Item>  getItems() {
        return items;
    }
}
