package com.adme.learning.spring.ai.demo;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Slf4j
public class SpringAiDemoApplication {


  public static void main(String[] args) {

    String openAiApiKey = System.getenv("OPEN_AI_API_KEY");

    Map.of("spring.ai.openai.api-key", openAiApiKey)
        .forEach(System::setProperty);

    SpringApplication.run(SpringAiDemoApplication.class, args);

  }


  @RestController
  @ResponseBody
  static class HomeController {

    private final OpenAiChatClient openAiChatClient;

    public HomeController(OpenAiChatClient openAiChatClient) {
      this.openAiChatClient = openAiChatClient;
    }

    @GetMapping("/ia/generate")
    public Map<String, String> generate(
        @RequestParam(value = "message", defaultValue = "tell me a joke") String message) {
      log.info("Message: {}", message);
      return Map.of("response", openAiChatClient.call(message));
    }
  }

}
