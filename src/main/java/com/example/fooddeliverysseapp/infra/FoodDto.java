package com.example.fooddeliverysseapp.infra;

import com.example.fooddeliverysseapp.domain.FoodStatus;

record FoodDto(String name, FoodStatus status) { }
