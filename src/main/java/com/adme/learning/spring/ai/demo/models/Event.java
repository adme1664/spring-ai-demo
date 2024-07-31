package com.adme.learning.spring.ai.demo.models;

import java.util.Objects;
import java.util.UUID;

public record Event(UUID idEvent, String nameEvent, String producer,String content) {

  public Event {

    if (Objects.isNull(nameEvent)) {
      throw new IllegalArgumentException("Event name cannot be null");
    }
    if (Objects.isNull(idEvent)) {
      throw new IllegalArgumentException("Event id cannot be null");
    }
    if (Objects.isNull(content)) {
      throw new IllegalArgumentException("Event content cannot be null");
    }
    if(Objects.isNull(producer)) {
      throw new IllegalArgumentException("Event producer cannot be null");
    }

  }

  public static class Builder {
     private UUID idEvent;
     private String nameEvent;
     private String content;
     private String producer;

     public  Builder idEvent() {
       this.idEvent = UUID.randomUUID();
       return this;
     }
     public Builder nameEvent(String nameEvent) {
       this.nameEvent = nameEvent;
       return this;
     }

     public Builder content(String content) {
       this.content = content;
       return this;
     }

     public Builder producer (String producer) {
       this.producer = producer;
       return this;
     }

     public Event build() {
       return new Event(idEvent, nameEvent, producer, content);
     }
  }


}
