package com.example.fooddeliverysseapp.application;

import com.example.fooddeliverysseapp.domain.OrderFood;
import com.example.fooddeliverysseapp.domain.FoodService;
import org.springframework.stereotype.Component;

@Component
class OrderFoodApplicaitonService implements FoodService {

    private final OrderFoodListener orderFoodListener;

    OrderFoodApplicaitonService(OrderFoodListener orderFoodListener) {
        this.orderFoodListener = orderFoodListener;
    }

    @Override
    public void order() {
       orderFoodListener.notifyAll(new OrderFood());
    }
}
