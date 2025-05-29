package com.gildedrose.inventory;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryTest {

    @Test
    void given_Item_NormalItem_when_DayPasses_then_QualityDegrades_and_Sellin_Drops(){

        // given
        Item item = new Item("NormalItem",1,3, ItemType.NORMAL_ITEM);
        Inventory inventory = new Inventory(List.of(item));

        // when
        inventory.dayPasses();

        // then
        assertEquals(0, inventory.getItems().get(0).getSellIn());
        assertEquals(2, inventory.getItems().get(0).getQuality());

    }

    @Test
    void given_Item_AgedBrie_when_DayPasses_then_QualityImproves_and_Sellin_Drops(){

        // given
        Item item = new Item("AgedBrieItem",1,3, ItemType.AGED_BRIE);
        Inventory inventory = new Inventory(List.of(item));

        // when
        inventory.dayPasses();

        // then
        assertEquals(0, inventory.getItems().get(0).getSellIn());
        assertEquals(4, inventory.getItems().get(0).getQuality());

    }

    @Test
    void given_Item_Sulfuras_when_DayPasses_then_QualityDontDecrease_and_Sellin_Drops(){

        // given
        Item item = new Item("SulfurasItem",1,3, ItemType.SULFURAS);
        Inventory inventory = new Inventory(List.of(item));

        // when
        inventory.dayPasses();

        // then
        assertEquals(1, inventory.getItems().get(0).getSellIn());
        assertEquals(3, inventory.getItems().get(0).getQuality());

    }

    @Test
    void  given_Item_Conjured_when_DayPasses_then_Quality_Degrade_Twice_and_Sellin_Drops(){

        // given
        Item item = new Item("ConjuredItem",3,6, ItemType.CONJURED);
        Inventory inventory = new Inventory(List.of(item));

        // when
        inventory.dayPasses();

        // then
        assertEquals(2, inventory.getItems().get(0).getSellIn());
        assertEquals(4, inventory.getItems().get(0).getQuality());

    }

    @Test
    void given_Item_NormalItem_when_Day_After_and_SellIn_Passed_then_Quality_Degrade_Twice_and_Sellin_Drops(){

        // given
        Item item = new Item("NormalItem",0,3, ItemType.NORMAL_ITEM);
        Inventory inventory = new Inventory(List.of(item));

        // when
        inventory.dayPasses();

        // then
        assertEquals(-1, inventory.getItems().get(0).getSellIn());
        assertEquals(1, inventory.getItems().get(0).getQuality());
    }

    @Test
    void given_Item_Backstage_Passes_when_Day_After_and_SellIn_Less_Than_10_then_Quality_Increases_Twice(){

        // given
        Item item = new Item("BackstagePassesItem",10,5, ItemType.BACKSTAGE_PASSES);
        Inventory inventory = new Inventory(List.of(item));

        // when
        inventory.dayPasses();

        // then
        assertEquals(9, inventory.getItems().get(0).getSellIn());
        assertEquals(7, inventory.getItems().get(0).getQuality());

    }

    @Test
    void given_Item_Backstage_Passes_when_Day_After_and_SellIn_Less_Than_5_then_Quality_Increases_Triple(){

        // given
        Item item = new Item("BackstagePassesItem",5,5, ItemType.BACKSTAGE_PASSES);
        Inventory inventory = new Inventory(List.of(item));

        // when
        inventory.dayPasses();

        // then
        assertEquals(4, inventory.getItems().get(0).getSellIn());
        assertEquals(8, inventory.getItems().get(0).getQuality());

    }

    @Test
    void given_Item_Backstage_Passes_when_Day_After_and_SellIn_Expired_then_Quality_Drops_To_Zero(){

        // given
        Item item = new Item("BackstagePassesItem",0,5, ItemType.BACKSTAGE_PASSES);
        Inventory inventory = new Inventory(List.of(item));

        // when
        inventory.dayPasses();

        // then
        assertEquals(-1, inventory.getItems().get(0).getSellIn());
        assertEquals(0, inventory.getItems().get(0).getQuality());

    }

}
