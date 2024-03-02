package com.example.fooddeliverysseapp.domain.observers;

import com.example.fooddeliverysseapp.domain.EventService;
import com.example.fooddeliverysseapp.domain.OrderFood;
import com.example.fooddeliverysseapp.domain.Observer;

import static com.example.fooddeliverysseapp.domain.FoodStatus.IN_THE_KITCHEN;
import static com.example.fooddeliverysseapp.domain.FoodStatus.ON_THE_WAY;

public class OnTheWayObservable extends Observer {

    public OnTheWayObservable(EventService eventService) {
        super(eventService);
    }

    @Override
    public void update(OrderFood orderFood) {

        if (orderFood.getStatus() == IN_THE_KITCHEN) {

            orderFood.setStatus(ON_THE_WAY);
            sendEvent(orderFood, "on-the-way");
            waitForProcess();
        }
    }
}
