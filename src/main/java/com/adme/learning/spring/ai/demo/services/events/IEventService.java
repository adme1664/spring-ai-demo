package com.adme.learning.spring.ai.demo.services.events;

import com.adme.learning.spring.ai.demo.models.Event;

public interface IEventService {

  void process(Event event);

}
