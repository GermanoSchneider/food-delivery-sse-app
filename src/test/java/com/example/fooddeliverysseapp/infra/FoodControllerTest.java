package com.example.fooddeliverysseapp.infra;

import com.example.fooddeliverysseapp.domain.EventService;
import com.example.fooddeliverysseapp.domain.Food;
import com.example.fooddeliverysseapp.domain.FoodService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import static java.lang.Long.MAX_VALUE;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FoodController.class)
class FoodControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventService eventService;

    @MockBean
    private FoodService foodService;

    private final ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void init() {
        mapper.registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());
    }

    @Test
    void shouldOpenSseConnection() throws Exception {

        var sseEmitter = new SseEmitter(MAX_VALUE);

        doReturn(sseEmitter).when(eventService).create();

        mockMvc.perform(
                get("/food-stream")
        ).andExpect(status().isOk());

        verify(eventService).create();
    }

    @Test
    void shouldOrderFood() throws Exception {

        var foodDto = DtoFixture.buildFoodDto();
        var food = new Food(foodDto.name(), foodDto.status());
        var json = mapper.writeValueAsString(foodDto);

        doNothing()
                .when(foodService)
                .order(food);

        mockMvc.perform(post("/order-food")
                        .content(json)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(foodService).order(food);
    }
}
