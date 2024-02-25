package com.example.fooddeliverysseapp.domain;

import com.example.fooddeliverysseapp.ModelFixture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class FoodTest {

    @Test
    void shouldBuildFoodModelWithSuccess() {

        assertDoesNotThrow(ModelFixture::buildFood);
    }
}
