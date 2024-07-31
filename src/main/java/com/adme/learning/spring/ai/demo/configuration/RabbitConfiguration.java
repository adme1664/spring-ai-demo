package com.adme.learning.spring.ai.demo.configuration;

import com.adme.learning.spring.ai.demo.models.Event;
import com.adme.learning.spring.ai.demo.services.MessageConsumerService;
import com.adme.learning.spring.ai.demo.services.MessageProducerService;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

@Configuration
public class RabbitConfiguration {

  @Bean
  Consumer<Event> messageConsumer(MessageConsumerService messageConsumerService) {
    return eventMessage -> messageConsumerService.consume(eventMessage);
  }

  @Bean
  Supplier<Message<Event>> messageSupplier(MessageProducerService producerService) {
    return producerService::supplyEvent;
  }

}
