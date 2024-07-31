package com.adme.learning.spring.ai.demo.services;

import com.adme.learning.spring.ai.demo.models.Event;
import com.adme.learning.spring.ai.demo.models.SystemEvent;
import com.adme.learning.spring.ai.demo.services.events.IEventService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class RouteMessageService {

  private final Map<String, IEventService> eventServiceMap;

  public RouteMessageService() {
    this.eventServiceMap = new HashMap<>();
  }

  public void routeEvent(Event event) {
    IEventService eventService = eventServiceMap.get(event.nameEvent());
    if (eventService == null) {
      throw new IllegalArgumentException("Event " + event.nameEvent() + " is not registered");
    }
    eventService.process(event);
  }

  public void registerEventService(SystemEvent event, final IEventService eventService) {
    this.eventServiceMap.put(event.nameEvent(), eventService);
  }
}
