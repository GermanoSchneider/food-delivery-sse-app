package com.example.fooddeliverysseapp.domain.observers;

import com.example.fooddeliverysseapp.domain.EventService;
import com.example.fooddeliverysseapp.domain.Food;
import com.example.fooddeliverysseapp.domain.Observer;

import static com.example.fooddeliverysseapp.domain.FoodStatus.ORDER_PLACED;

public class OrderObservable extends Observer {

    public OrderObservable(EventService eventService) {
        super(eventService);
    }

    @Override
    public void update(Food food) {

        if (food.getStatus() == ORDER_PLACED) {

            sendEvent(food, "order");
        }
    }
}
