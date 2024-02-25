package com.example.fooddeliverysseapp.infra;

import static com.example.fooddeliverysseapp.domain.FoodStatus.IN_THE_KITCHEN;

class DtoFixture {

    private DtoFixture() {}

    public static FoodDto buildFoodDto() {

        return new FoodDto("Hamburguer");
    }
}
