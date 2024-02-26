package com.example.fooddeliverysseapp.application;

import com.example.fooddeliverysseapp.ModelFixture;
import com.example.fooddeliverysseapp.domain.EventService;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Duration;

import static com.example.fooddeliverysseapp.domain.FoodStatus.DELIVERED;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class FoodListenerTest {

    @InjectMocks
    private FoodListener foodListener;

    @Mock
    private EventService eventService;

    @BeforeEach
    void init() {
        Awaitility.setDefaultTimeout(Duration.ofMinutes(1L));
    }

    @Test
    void shouldNotifyAllObservables() {

        var food = ModelFixture.buildFood();

        foodListener.notifyAll(food);

        Awaitility.await().untilAsserted(() -> assertEquals(DELIVERED, food.getStatus()));
    }
}
