package com.example.fooddeliverysseapp.infra;

import com.example.fooddeliverysseapp.domain.Food;

class FoodMapper {

    private FoodMapper() {}

    public static Food fromFoodDto(FoodDto foodDto) {

        return new Food(foodDto.name(), foodDto.status());
    }
}
