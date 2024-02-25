package com.example.fooddeliverysseapp.infra;

import com.example.fooddeliverysseapp.domain.Food;
import com.example.fooddeliverysseapp.domain.FoodStatus;

class FoodMapper {

    private FoodMapper() {}

    public static Food fromOrderRequest(FoodDto foodDto) {

        return new Food(foodDto.name(), FoodStatus.ORDER_PLACED);
    }
}
