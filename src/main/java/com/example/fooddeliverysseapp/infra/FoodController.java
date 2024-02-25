package com.example.fooddeliverysseapp.infra;

import com.example.fooddeliverysseapp.domain.EventService;
import com.example.fooddeliverysseapp.domain.FoodService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import static com.example.fooddeliverysseapp.infra.FoodMapper.fromOrderRequest;

@RestController
class FoodController {

    private final EventService eventService;

    private final FoodService foodService;

    FoodController(EventService eventService, FoodService foodService) {
        this.eventService = eventService;
        this.foodService = foodService;
    }

    @GetMapping(path = "/food-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    SseEmitter foodStream() {
        return eventService.create();
    }

    @PostMapping(path = "/order-food", produces = MediaType.APPLICATION_JSON_VALUE)
    void orderFood(@RequestBody FoodDto foodDto) {

        foodService.order(fromOrderRequest(foodDto));
    }
}
