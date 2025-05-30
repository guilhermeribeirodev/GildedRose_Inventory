package com.gildedrose.inventory.controller;

import com.gildedrose.inventory.util.FileUtil;
import com.gildedrose.inventory.util.MapperUtil;
import com.gildedrose.inventory.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemControllerTest {

        final TestRestTemplate testRestTemplate = new TestRestTemplate();

        @Test
        void postItems() throws IOException {
                String productJson = FileUtil.readFromFileToString("./items.json");
                Item[] items = MapperUtil.deserializeProduct(productJson);

                HttpHeaders header=new HttpHeaders();
                header.setContentType(MediaType.APPLICATION_JSON);

                //HttpEntity<Request> requestEntity=new HttpEntity<>(request,header);

                final HttpEntity<Item[] > httpEntity = new HttpEntity<>(items, header);
                ResponseEntity<Item[]> response = testRestTemplate
                       // .withBasicAuth("ADMIN_TEST_LOGIN", "ADMIN_TEST_PASSWORD")
                        .postForEntity("http://localhost:8080/items", httpEntity,   Item[].class);

                assertEquals(HttpStatus.CREATED, response.getStatusCode());
        }
}
