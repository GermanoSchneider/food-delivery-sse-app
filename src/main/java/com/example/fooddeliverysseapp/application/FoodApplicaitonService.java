package com.example.fooddeliverysseapp.application;

import com.example.fooddeliverysseapp.domain.Food;
import com.example.fooddeliverysseapp.domain.FoodService;
import org.springframework.stereotype.Component;

@Component
class FoodApplicaitonService implements FoodService {

    private final FoodListener foodListener;

    FoodApplicaitonService(FoodListener foodListener) {
        this.foodListener = foodListener;
    }

    @Override
    public void order(Food food) {
       foodListener.notifyAll(food);
    }
}
