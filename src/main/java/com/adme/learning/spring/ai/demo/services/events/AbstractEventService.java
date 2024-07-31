package com.adme.learning.spring.ai.demo.services.events;

import com.adme.learning.spring.ai.demo.models.SystemEvent;
import com.adme.learning.spring.ai.demo.services.RouteMessageService;
import jakarta.annotation.PostConstruct;
import java.util.List;

public abstract class AbstractEventService implements IEventService {

  private final RouteMessageService routeMessageService;

  protected AbstractEventService(RouteMessageService routeMessageService) {
    this.routeMessageService = routeMessageService;
  }

  protected abstract List<SystemEvent> getEvents();

  @PostConstruct
  public void initEvent(){
    getEvents().forEach(systemEvent -> this.routeMessageService.registerEventService(systemEvent,this));
  }
}
