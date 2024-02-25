package com.example.fooddeliverysseapp.application;

import com.example.fooddeliverysseapp.domain.EventService;
import com.example.fooddeliverysseapp.domain.Food;
import com.example.fooddeliverysseapp.domain.FoodService;
import org.springframework.stereotype.Component;

@Component
class FoodApplicaitonService implements FoodService {

    private final EventService eventService;

    FoodApplicaitonService(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public void order(Food food) {
        eventService.sendEvent(food, "order");
    }
}
