package com.example.fooddeliverysseapp.domain.observers;

import com.example.fooddeliverysseapp.ModelFixture;
import com.example.fooddeliverysseapp.domain.EventService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.fooddeliverysseapp.domain.FoodStatus.ORDER_PLACED;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class OrderObservableTest {

    @Mock
    private EventService eventService;

    @Test
    void shouldUpdateAnOrderObservable() {

        var observer = new OrderObservable(eventService);
        var food = ModelFixture.buildFood();

        Mockito.doNothing().when(eventService).sendEvent(food, "order");

        observer.update(food);

        assertEquals(ORDER_PLACED, food.getStatus());
    }
}
