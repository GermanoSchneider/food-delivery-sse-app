package com.example.fooddeliverysseapp.domain;

public class Food {

    private final String name;

    private FoodStatus status;

    public Food(String name, FoodStatus status) {
        this.name = name;
        this.status = status;
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
