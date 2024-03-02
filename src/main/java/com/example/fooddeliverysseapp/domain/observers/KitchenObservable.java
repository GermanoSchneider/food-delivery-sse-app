package com.example.fooddeliverysseapp.domain.observers;

import com.example.fooddeliverysseapp.domain.EventService;
import com.example.fooddeliverysseapp.domain.OrderFood;
import com.example.fooddeliverysseapp.domain.Observer;
import com.example.fooddeliverysseapp.domain.FoodStatus;

public class KitchenObservable extends Observer {

    public KitchenObservable(EventService eventService) {
        super(eventService);
    }

    @Override
    public void update(OrderFood orderFood) {

        if (orderFood.getStatus() == FoodStatus.ORDER_PLACED) {

            orderFood.setStatus(FoodStatus.IN_THE_KITCHEN);
            sendEvent(orderFood, "kitchen");
            waitForProcess();
        }
    }
}
