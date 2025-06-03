package com.gildedrose.inventory.mapper;

import com.gildedrose.inventory.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.gildedrose.inventory.model.ItemType.*;

@Component
public class ItemsMapper {

    public  List<Item> map(List<Item> items){
        List<Item> mappedItems = new ArrayList<>();

        for(Item item : items){
            if(item.getDisplayName().matches(AGED_BRIE.getDisplayName())) {
                mappedItems.add(new AgedBrie(item));
            }else if(item.getDisplayName().matches(NORMAL_ITEM.getDisplayName())){
                mappedItems.add(new NormalItem(item));
            }else if(item.getDisplayName().matches(CONJURED.getDisplayName())){
                mappedItems.add(new ConjuredItem(item));
            }else if(item.getDisplayName().matches(SULFURAS.getDisplayName())){
                mappedItems.add(new Sulfuras(item));
            }else if(item.getDisplayName().matches(BACKSTAGE_PASSES.getDisplayName())){
                mappedItems.add(new BackstagePasses(item));
            }else{
                mappedItems.add(new Item("NO SUCH ITEM",0,0,null));
            }
        }

        return mappedItems;
    }
}
