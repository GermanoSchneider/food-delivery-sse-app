package com.example.fooddeliverysseapp.application;

import com.example.fooddeliverysseapp.domain.EventService;
import com.example.fooddeliverysseapp.domain.Food;
import com.example.fooddeliverysseapp.domain.Observer;
import com.example.fooddeliverysseapp.domain.observers.DeliveredObservable;
import com.example.fooddeliverysseapp.domain.observers.OnTheWayObservable;
import com.example.fooddeliverysseapp.domain.observers.KitchenObservable;
import com.example.fooddeliverysseapp.domain.observers.OrderObservable;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class FoodListener {

    private final EventService eventService;

    private final Collection<Observer> observers;

    public FoodListener(EventService eventService) {
        this.eventService = eventService;
        this.observers = List.of(
                new OrderObservable(eventService),
                new KitchenObservable(eventService),
                new OnTheWayObservable(eventService),
                new DeliveredObservable(eventService)
        );
    }

    public void notifyAll(Food food) {
        observers.forEach(foodObserver -> foodObserver.update(food));
    }
}
