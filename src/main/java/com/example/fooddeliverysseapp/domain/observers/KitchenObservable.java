package com.example.fooddeliverysseapp.domain.observers;

import com.example.fooddeliverysseapp.domain.EventService;
import com.example.fooddeliverysseapp.domain.Food;
import com.example.fooddeliverysseapp.domain.Observer;
import com.example.fooddeliverysseapp.domain.FoodStatus;

public class KitchenObservable extends Observer {

    public KitchenObservable(EventService eventService) {
        super(eventService);
    }

    @Override
    public void update(Food food) {

        if (food.getStatus() == FoodStatus.ORDER_PLACED) {

            sendEvent(food, "kitchen");
            food.setStatus(FoodStatus.IN_THE_KITCHEN);
            waitForProcess();
        }
    }
}
