package com.example.fooddeliverysseapp.infra;

class DtoFixture {

    private DtoFixture() {}

    public static OrderFoodDto buildFoodDto() {

        return new OrderFoodDto("Hamburguer");
    }
}
