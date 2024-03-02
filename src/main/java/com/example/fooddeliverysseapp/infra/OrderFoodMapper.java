package com.example.fooddeliverysseapp.infra;

import com.example.fooddeliverysseapp.domain.OrderFood;
import com.example.fooddeliverysseapp.domain.FoodStatus;

class OrderFoodMapper {

    private OrderFoodMapper() {}

    public static OrderFood fromOrderRequest(OrderFoodDto foodDto) {

        return new OrderFood(foodDto.name(), FoodStatus.ORDER_PLACED);
    }
}
