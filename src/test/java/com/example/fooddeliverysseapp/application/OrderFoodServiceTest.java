package com.example.fooddeliverysseapp.application;

import com.example.fooddeliverysseapp.ModelFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
class OrderFoodServiceTest {

    @InjectMocks
    private OrderFoodApplicaitonService foodService;

    @Mock
    private OrderFoodListener orderFoodListener;

    @Test
    void shouldOrderFoodWithSuccess() {

        var food = ModelFixture.buildFood();

        doNothing().when(orderFoodListener).notifyAll(food);

        assertDoesNotThrow(() -> foodService.order(food));
    }
}
