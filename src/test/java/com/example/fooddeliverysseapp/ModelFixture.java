package com.example.fooddeliverysseapp;

import com.example.fooddeliverysseapp.domain.OrderFood;

public class ModelFixture {

    private ModelFixture() {}

    public static OrderFood buildFood() {

        return new OrderFood();
    }
}
