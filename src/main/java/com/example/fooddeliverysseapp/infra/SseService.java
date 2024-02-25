package com.example.fooddeliverysseapp.infra;

import com.example.fooddeliverysseapp.domain.EventService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.lang.Long.MAX_VALUE;
import static org.springframework.web.servlet.mvc.method.annotation.SseEmitter.event;

@Component
class SseService implements EventService {

    private final Collection<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    @Override
    public SseEmitter create() {

        SseEmitter emitter = new SseEmitter(MAX_VALUE);

        emitter.onCompletion(() -> emitters.remove(emitter));

        emitters.add(emitter);

        return emitter;
    }

    @Override
    public <T> void sendEvent(T payload, String eventName) {

        var event = event().data(payload).name(eventName).build();

        for (SseEmitter emitter : emitters) {
            try {
                emitter.send(event);
            } catch (IOException exception) {
                emitter.completeWithError(exception);
            }
        }
    }
}
