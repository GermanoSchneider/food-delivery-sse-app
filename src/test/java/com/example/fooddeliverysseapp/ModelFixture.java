package com.example.fooddeliverysseapp;

import com.example.fooddeliverysseapp.domain.Food;

import static com.example.fooddeliverysseapp.domain.FoodStatus.ORDER_PLACED;

public class ModelFixture {

    private ModelFixture() {}

    public static Food buildFood() {

        return new Food("Pizza", ORDER_PLACED);
    }
}
