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

import static com.example.fooddeliverysseapp.domain.FoodStatus.IN_THE_KITCHEN;
import static org.awaitility.Awaitility.await;
import static org.awaitility.Awaitility.setDefaultTimeout;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class KitchenObservableTest {

    @Mock
    private EventService eventService;

    @BeforeEach
    void init() {
        setDefaultTimeout(Duration.ofMinutes(1L));
    }

    @Test
    void shouldUpdateAKitchenObservable() {

        var observer = new KitchenObservable(eventService);
        var food = ModelFixture.buildFood();

        Mockito.doNothing().when(eventService).sendEvent(food, "kitchen");

        observer.update(food);

        await().untilAsserted(() -> assertEquals(IN_THE_KITCHEN, food.getStatus()));
    }
}
