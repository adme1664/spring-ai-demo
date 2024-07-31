package com.adme.learning.spring.ai.demo.configuration;

import jakarta.annotation.PostConstruct;
import java.util.Map;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class OpenAiConfiguration {

 // @PostConstruct
  public void setConfiguration(){
    String openAiApiKey = System.getenv("OPEN_AI_API_KEY");
    Map.of("spring.ai.openai.api-key", openAiApiKey)
        .forEach(System::setProperty);
  }

}
