package com.example.fooddeliverysseapp.infra;

import com.example.fooddeliverysseapp.domain.EventService;
import com.example.fooddeliverysseapp.domain.FoodService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
class OrderFoodController {

    private final EventService eventService;

    private final FoodService foodService;

    OrderFoodController(EventService eventService, FoodService foodService) {
        this.eventService = eventService;
        this.foodService = foodService;
    }

    @GetMapping(path = "/order-status", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    SseEmitter orderStatus() {
        return eventService.create();
    }

    @PostMapping(path = "/order-food", produces = MediaType.APPLICATION_JSON_VALUE)
    void orderFood() {

        foodService.order();
    }
}
