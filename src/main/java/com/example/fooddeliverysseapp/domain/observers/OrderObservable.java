package com.example.fooddeliverysseapp.domain.observers;

import com.example.fooddeliverysseapp.domain.EventService;
import com.example.fooddeliverysseapp.domain.OrderFood;
import com.example.fooddeliverysseapp.domain.Observer;

import static com.example.fooddeliverysseapp.domain.FoodStatus.ORDER_PLACED;

public class OrderObservable extends Observer {

    public OrderObservable(EventService eventService) {
        super(eventService);
    }

    @Override
    public void update(OrderFood orderFood) {

        if (orderFood.getStatus() == ORDER_PLACED) {

            sendEvent(orderFood, "order");
        }
    }
}
