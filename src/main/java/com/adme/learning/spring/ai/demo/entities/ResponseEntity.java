package com.adme.learning.spring.ai.demo.entities;

import java.util.Objects;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record ResponseEntity(
  @Id  UUID id,
  String message,
  String receiver,
  String sender
) {
  public ResponseEntity{
    if(Objects.isNull(id)){
      id = UUID.randomUUID();
    }
  }

}
