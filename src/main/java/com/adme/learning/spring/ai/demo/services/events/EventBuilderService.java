package com.adme.learning.spring.ai.demo.services.events;

import com.adme.learning.spring.ai.demo.models.Event;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class EventBuilderService {

  private static final String PRODUCER = "open.ai.producer";

  public Event buildEvent(Event event, Map<String, String> mapResponse) {
    String response = mapResponse.get("response");
    return new Event.Builder().idEvent()
        .nameEvent("anthropic.ai.conversation.message")
        .content(response)
        .producer(PRODUCER)
        .build();

  }

}
