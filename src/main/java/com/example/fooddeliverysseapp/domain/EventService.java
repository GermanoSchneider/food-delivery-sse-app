package com.example.fooddeliverysseapp.domain;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public interface EventService {

    SseEmitter create();

    <T> void sendEvent(T payload, String eventName);
}
