package com.example.fooddeliverysseapp.infra;

import com.example.fooddeliverysseapp.domain.EventService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.util.ReflectionTestUtils.getField;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@SpringBootTest(classes = SseService.class)
class SseServiceTest {

    @Autowired
    private EventService eventService;

    private Collection<SseEmitter> emitters;

    @BeforeEach
    void init() {
        emitters = (Collection<SseEmitter>) getField(eventService, "emitters");
    }

    @AfterEach
    void end() {
        emitters.clear();
    }

    @Test
    void shouldCreateSseEmitterWithSuccess() {

        var emitter = eventService.create();

        assertEquals(1, emitters.size());
        assertTrue(emitters.contains(emitter));
    }

    @Test
    void shouldSendEventWithSuccess() {

        var emitter = new SseEmitter();

        setField(eventService, "emitters", List.of(emitter));

        String payload = "this is a test payload";
        String eventName = "testEvent";

        assertDoesNotThrow(() -> eventService.sendEvent(payload, eventName));
        assertTrue(emitters.isEmpty());
    }
}
