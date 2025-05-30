package com.gildedrose.inventory;

import com.gildedrose.inventory.model.Item;
import com.gildedrose.inventory.util.FileUtil;
import com.gildedrose.inventory.util.MapperUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class IntegrationTest {

    TestRestTemplate testRestTemplate = new TestRestTemplate();

    @Test
    void postItems() throws IOException {
        String itemsInputString = FileUtil.readFromFileToString("itemsInput.json");
        Item[] itemsInput = MapperUtil.deserialize(itemsInputString);

        String itemsOutputString = FileUtil.readFromFileToString("itemsOutput.json");
        Item[] itemsOutput = MapperUtil.deserialize(itemsOutputString);

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        final HttpEntity<Item[]> httpEntity = new HttpEntity<>(itemsInput, header);
        ResponseEntity<Item[]> response = testRestTemplate
                .withBasicAuth("ADMIN_TEST_LOGIN", "ADMIN_TEST_PASSWORD")
                .postForEntity("http://localhost:8080/items", httpEntity, Item[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertArrayEquals(itemsOutput, response.getBody());;
    }
}
