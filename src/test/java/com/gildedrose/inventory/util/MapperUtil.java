package com.gildedrose.inventory.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gildedrose.inventory.model.Item;

public class MapperUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static  Item[] deserialize(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, Item[].class);
    }
}
