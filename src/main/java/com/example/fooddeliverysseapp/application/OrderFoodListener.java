package com.example.fooddeliverysseapp.application;

import com.example.fooddeliverysseapp.domain.EventService;
import com.example.fooddeliverysseapp.domain.OrderFood;
import com.example.fooddeliverysseapp.domain.Observer;
import com.example.fooddeliverysseapp.domain.observers.DeliveredObservable;
import com.example.fooddeliverysseapp.domain.observers.OnTheWayObservable;
import com.example.fooddeliverysseapp.domain.observers.KitchenObservable;
import com.example.fooddeliverysseapp.domain.observers.OrderObservable;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class OrderFoodListener {

    private final EventService eventService;

    private final Collection<Observer> observers;

    public OrderFoodListener(EventService eventService) {
        this.eventService = eventService;
        this.observers = List.of(
                new OrderObservable(eventService),
                new KitchenObservable(eventService),
                new OnTheWayObservable(eventService),
                new DeliveredObservable(eventService)
        );
    }

    synchronized public void notifyAll(OrderFood orderFood) {
        observers.forEach(foodObserver -> foodObserver.update(orderFood));
    }
}
