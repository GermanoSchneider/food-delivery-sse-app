package com.example.fooddeliverysseapp.domain.observers;

import com.example.fooddeliverysseapp.ModelFixture;
import com.example.fooddeliverysseapp.domain.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Duration;

import static com.example.fooddeliverysseapp.domain.FoodStatus.DELIVERED;
import static com.example.fooddeliverysseapp.domain.FoodStatus.ON_THE_WAY;
import static org.awaitility.Awaitility.setDefaultTimeout;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class DeliveredObservableTest {

    @Mock
    private EventService eventService;

    @BeforeEach
    void init() {
        setDefaultTimeout(Duration.ofMinutes(1L));
    }

    @Test
    void shouldUpdateADeliveredObservable() {

        var observer = new DeliveredObservable(eventService);
        var food = ModelFixture.buildFood();
        food.setStatus(ON_THE_WAY);

        Mockito.doNothing().when(eventService).sendEvent(food, "delivered");

        observer.update(food);

        assertEquals(DELIVERED, food.getStatus());
    }
}
