package com.example.fooddeliverysseapp;

import com.example.fooddeliverysseapp.domain.Food;

public class ModelFixture {

    private ModelFixture() {}

    public static Food buildFood() {

        return new Food("Pizza");
    }
}
