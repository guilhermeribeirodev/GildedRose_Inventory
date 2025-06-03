package com.gildedrose.inventory;

import com.gildedrose.inventory.model.*;
import com.gildedrose.inventory.service.Inventory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryTest {

    private Inventory subject;

    @BeforeEach
    void setUp(){
        subject = new Inventory();
    }

    @AfterEach
    void tearDown(){
        subject = null;
    }

    @Test
    void given_Item_NormalItem_when_DayPasses_then_QualityDegrades_and_Sellin_Drops(){

        // given
        Item item = new NormalItem("NormalItem",1,3, ItemType.NORMAL_ITEM);

        // when
        List<Item> items = List.of(item);
        List<Item> updatedItems =  subject.dayPasses(items);

        // then
        assertEquals(0, updatedItems.get(0).getSellIn());
        assertEquals(2, updatedItems.get(0).getQuality());

    }

    @Test
    void given_Item_AgedBrie_when_DayPasses_then_QualityImproves_and_Sellin_Drops(){

        // given
        Item item = new AgedBrie("AgedBrieItem",1,3, ItemType.AGED_BRIE);

        // when
        List<Item> items = List.of(item);
        List<Item> updatedItems =  subject.dayPasses(items);

        // then
        assertEquals(0, updatedItems.get(0).getSellIn());
        assertEquals(4, updatedItems.get(0).getQuality());

    }

    @Test
    void given_Item_Sulfuras_when_DayPasses_then_QualityDontDecrease_and_Sellin_Drops(){

        // given
        Item item = new Sulfuras("SulfurasItem",1,3, ItemType.SULFURAS);

        // when
        List<Item> items = List.of(item);
        List<Item> updatedItems = subject.dayPasses(items);

        // then
        assertEquals(1, updatedItems.get(0).getSellIn());
        assertEquals(3, updatedItems.get(0).getQuality());

    }

    @Test
    void  given_Item_Conjured_when_DayPasses_then_Quality_Degrade_Twice_and_Sellin_Drops(){

        // given
        Item item = new ConjuredItem("ConjuredItem",3,6, ItemType.CONJURED);

        // when
        List<Item> items = List.of(item);
        List<Item> updatedItems = subject.dayPasses(items);

        // then
        assertEquals(2, updatedItems.get(0).getSellIn());
        assertEquals(4, updatedItems.get(0).getQuality());

    }

    @Test
    void given_Item_NormalItem_when_Day_Passes_and_SellIn_Passed_then_Quality_Degrade_Twice_and_Sellin_Drops(){

        // given
        Item item = new NormalItem("NormalItem",0,3, ItemType.NORMAL_ITEM);

        // when
        List<Item> items = List.of(item);
        List<Item> updatedItems = subject.dayPasses(items);

        // then
        assertEquals(-1, updatedItems.get(0).getSellIn());
        assertEquals(1, updatedItems.get(0).getQuality());
    }

    @Test
    void given_Item_Backstage_Passes_when_Day_Passes_and_SellIn_Less_Than_10_then_Quality_Increases_Twice(){

        // given
        Item item = new BackstagePasses("BackstagePassesItem",10,5, ItemType.BACKSTAGE_PASSES);

        // when
        List<Item> items = List.of(item);
        List<Item> updatedItems = subject.dayPasses(items);

        // then
        assertEquals(9, updatedItems.get(0).getSellIn());
        assertEquals(7, updatedItems.get(0).getQuality());

    }

    @Test
    void given_Item_Backstage_Passes_when_Day_Passes_and_SellIn_Less_Than_5_then_Quality_Increases_Triple(){

        // given
        Item item = new BackstagePasses("BackstagePassesItem",5,5, ItemType.BACKSTAGE_PASSES);

        // when
        List<Item> items = List.of(item);
        List<Item> updatedItems =  subject.dayPasses(items);

        // then
        assertEquals(4, updatedItems.get(0).getSellIn());
        assertEquals(8, updatedItems.get(0).getQuality());

    }

    @Test
    void given_Item_Backstage_Passes_when_Day_Passes_and_SellIn_Expired_then_Quality_Drops_To_Zero(){

        // given
        Item item = new BackstagePasses("BackstagePassesItem",0,5, ItemType.BACKSTAGE_PASSES);

        // when
        List<Item> items = List.of(item);
        List<Item> updatedItems = subject.dayPasses(items);

        // then
        assertEquals(-1, updatedItems.get(0).getSellIn());
        assertEquals(0, updatedItems.get(0).getQuality());

    }

    @Test
    void given_Invalid_Item_when_Day_Passes_then_Return_No_Such_Item(){

        // given
        Item item = new Item("NO SUCH ITEM",2,2, null);

        // when
        List<Item> items = List.of(item);
        List<Item> updatedItems = subject.dayPasses(items);

        //then
        assertEquals("NO SUCH ITEM", updatedItems.get(0).getDisplayName());
    }

}
