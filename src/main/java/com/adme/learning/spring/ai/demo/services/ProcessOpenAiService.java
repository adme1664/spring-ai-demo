package com.adme.learning.spring.ai.demo.services;

import com.adme.learning.spring.ai.demo.models.Event;
import com.adme.learning.spring.ai.demo.models.SystemEvent;
import com.adme.learning.spring.ai.demo.services.events.AbstractEventService;
import com.adme.learning.spring.ai.demo.services.events.EventBuilderService;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public final class ProcessOpenAiService extends AbstractEventService {

  private final OpenAiChatClient openAiChatClient;
  private final MessageProducerService messageProducerService;
  private final EventBuilderService eventBuilderService;

  public ProcessOpenAiService(OpenAiChatClient openAiChatClient,
      MessageProducerService messageProducerService, EventBuilderService eventBuilderService,
      RouteMessageService routeMessageService) {
    super(routeMessageService);
    this.openAiChatClient = openAiChatClient;
    this.messageProducerService = messageProducerService;
    this.eventBuilderService = eventBuilderService;
  }

  @Override
  public void process(Event event) {

    log.info("Anthropic talks: {}", event.content());

    Map<String, String> mapResponse = Map.of("response", openAiChatClient.call(event.content()));

    log.info("Open AI answers: {}", mapResponse.get("response"));

    Event eventToSend = this.eventBuilderService.buildEvent(event, mapResponse);

    this.messageProducerService.sendEvent(eventToSend);

  }

  @Override
  protected List<SystemEvent> getEvents() {
    return List.of(new SystemEvent("open.ai.conversation.message"));
  }
}
