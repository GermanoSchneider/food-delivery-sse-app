package com.example.fooddeliverysseapp;

import com.example.fooddeliverysseapp.domain.OrderFood;

import static com.example.fooddeliverysseapp.domain.FoodStatus.ORDER_PLACED;

public class ModelFixture {

    private ModelFixture() {}

    public static OrderFood buildFood() {

        return new OrderFood("Pizza", ORDER_PLACED);
    }
}
