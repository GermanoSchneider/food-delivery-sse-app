package com.example.fooddeliverysseapp.domain.observers;

import com.example.fooddeliverysseapp.domain.EventService;
import com.example.fooddeliverysseapp.domain.OrderFood;
import com.example.fooddeliverysseapp.domain.FoodStatus;
import com.example.fooddeliverysseapp.domain.Observer;

public class DeliveredObservable extends Observer {

    public DeliveredObservable(EventService eventService) {
        super(eventService);
    }

    @Override
    public void update(OrderFood orderFood) {

        if (orderFood.getStatus() == FoodStatus.ON_THE_WAY) {

            orderFood.setStatus(FoodStatus.DELIVERED);
            sendEvent(orderFood, "delivered");
        }
    }
}
