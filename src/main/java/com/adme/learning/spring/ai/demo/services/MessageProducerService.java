package com.adme.learning.spring.ai.demo.services;

import com.adme.learning.spring.ai.demo.models.Event;
import java.util.Optional;
import java.util.concurrent.LinkedBlockingDeque;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public final class MessageProducerService {

  private final static String HEADERS_TYPE = "type";
  private final LinkedBlockingDeque<Event> events;

  public MessageProducerService() {
    events = new LinkedBlockingDeque<>();
  }

  public void sendEvent(Event event) {
    events.add(event);
  }

  public Message<Event> supplyEvent() {

    try {
      Thread.sleep(60000);
      return Optional.ofNullable(events.poll())
          .map(event -> {
            //log.info("Sending event: {}", event);
            return MessageBuilder.withPayload(event)
                .setHeader(HEADERS_TYPE, event.nameEvent())
                .build();
          }).orElse(null);
    } catch (InterruptedException e) {
      log.error(e.getMessage(), e);
    }
    return null;

  }

}
