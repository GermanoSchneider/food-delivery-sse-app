package com.example.fooddeliverysseapp.domain;

import java.util.Random;

import static java.lang.Double.*;

public abstract class Observer {

    private final EventService eventService;

    protected Observer(EventService eventService) {
        this.eventService = eventService;
    }

    protected void waitForProcess() {

        Random random = new Random();

        double randomTime = random.nextDouble(2000, 10000);

        try {
            Thread.sleep(valueOf(randomTime).longValue());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void sendEvent(OrderFood orderFood, String eventName) {
        eventService.sendEvent(orderFood, eventName);
    }

    public abstract void update(OrderFood orderFood);
}
