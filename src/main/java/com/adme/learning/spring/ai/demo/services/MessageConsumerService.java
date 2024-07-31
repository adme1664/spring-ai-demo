package com.adme.learning.spring.ai.demo.services;

import com.adme.learning.spring.ai.demo.models.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageConsumerService {
  private  final RouteMessageService routeMessageService;

  public MessageConsumerService(RouteMessageService routeMessageService) {
    this.routeMessageService = routeMessageService;
  }

  public void consume(Event event) {
    //log.info("Consuming this message {}", event.toString());
    this.routeMessageService.routeEvent(event);
  }

}
