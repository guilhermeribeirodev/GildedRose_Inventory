package com.gildedrose.inventory.controller;

import com.gildedrose.inventory.model.Item;
import com.gildedrose.inventory.util.FileUtil;
import com.gildedrose.inventory.util.MapperUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @MockitoBean
//    private ItemsMapper itemsMapper;

    @Test
    void shouldReturnValidOutputForGivenInput() throws Exception {

        final String itemsInputString = FileUtil.readFromFileToString("itemsInput.json");
        final Item[] itemsInput = MapperUtil.deserialize(itemsInputString);

        final String itemsOutputString = FileUtil.readFromFileToString("itemsOutput.json");
        final Item[] itemsOutput = MapperUtil.deserialize(itemsOutputString);

        //when(itemsMapper.map(any())).thenReturn(Arrays.asList(itemsInput));

        this.mockMvc.perform(post("/items")
                        .content(itemsInputString)
                        .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(itemsOutputString));
    }
}
