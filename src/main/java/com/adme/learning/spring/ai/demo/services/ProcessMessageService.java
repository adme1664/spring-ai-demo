package com.adme.learning.spring.ai.demo.services;

import com.adme.learning.spring.ai.demo.entities.ResponseEntity;
import com.adme.learning.spring.ai.demo.mapper.ResponseMapper;
import com.adme.learning.spring.ai.demo.models.ResponseDto;
import com.adme.learning.spring.ai.demo.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public final class ProcessMessageService {
  private final MessageRepository messageRepository;

  public ProcessMessageService(MessageRepository messageRepository) {
    this.messageRepository = messageRepository;
  }

  public ResponseDto saveMessage(ResponseEntity message){
    log.info("Saving new message");
    return ResponseMapper.mapToDto(messageRepository.save(message));
  }
}
