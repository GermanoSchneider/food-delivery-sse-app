package com.example.fooddeliverysseapp.application;

import com.example.fooddeliverysseapp.domain.OrderFood;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
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

    @Captor
    private ArgumentCaptor<OrderFood> orderFood;

    @Test
    void shouldOrderFoodWithSuccess() {

        doNothing().when(orderFoodListener).notifyAll(orderFood.capture());

        assertDoesNotThrow(() -> foodService.order());
    }
}
