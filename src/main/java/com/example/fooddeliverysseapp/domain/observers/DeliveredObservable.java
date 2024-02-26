package com.example.fooddeliverysseapp.domain.observers;

import com.example.fooddeliverysseapp.domain.EventService;
import com.example.fooddeliverysseapp.domain.Food;
import com.example.fooddeliverysseapp.domain.FoodStatus;
import com.example.fooddeliverysseapp.domain.Observer;

public class DeliveredObservable extends Observer {

    public DeliveredObservable(EventService eventService) {
        super(eventService);
    }

    @Override
    public void update(Food food) {

        if (food.getStatus() == FoodStatus.ON_THE_WAY) {
            sendEvent(food, "delivered");
            food.setStatus(FoodStatus.DELIVERED);
        }
    }
}
