package com.example.fooddeliverysseapp.domain;

import java.util.Random;

import static com.example.fooddeliverysseapp.domain.FoodStatus.ORDER_PLACED;

public class OrderFood {

    private final Integer id;

    private FoodStatus status;

    public OrderFood() {
        this.id = new Random().nextInt(3000, 5000);
        this.status = ORDER_PLACED;
    }

    public Integer getId() {
        return id;
    }

    public FoodStatus getStatus() {
        return status;
    }

    public void setStatus(FoodStatus status) {
        this.status = status;
    }
}
