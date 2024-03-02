package com.example.fooddeliverysseapp.domain;

import java.util.Random;

public class OrderFood {

    private final Integer id;

    private final String name;

    private FoodStatus status;

    public OrderFood(String name, FoodStatus status) {
        this.id = new Random().nextInt(3000, 5000);
        this.name = name;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public FoodStatus getStatus() {
        return status;
    }

    public void setStatus(FoodStatus status) {
        this.status = status;
    }
}
