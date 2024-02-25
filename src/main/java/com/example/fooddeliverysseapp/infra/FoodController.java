package com.example.fooddeliverysseapp.infra;

import com.example.fooddeliverysseapp.domain.EventService;
import com.example.fooddeliverysseapp.domain.Food;
import com.example.fooddeliverysseapp.domain.FoodService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.fooddeliverysseapp.infra.FoodMapper.*;

@RestController
class FoodController {

    private final EventService eventService;

    private final FoodService foodService;

    FoodController(EventService eventService, FoodService foodService) {
        this.eventService = eventService;
        this.foodService = foodService;
    }

    @GetMapping(path = "/food-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    void foodStream() {
        eventService.create();
    }

    @PostMapping(path = "/order-food", produces = MediaType.APPLICATION_JSON_VALUE)
    void orderFood(@RequestBody FoodDto foodDto) {

        foodService.order(fromFoodDto(foodDto));
    }
}
