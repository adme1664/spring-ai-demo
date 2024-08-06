package com.adme.learning.spring.ai.demo.repository;

import com.adme.learning.spring.ai.demo.entities.ResponseEntity;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<ResponseEntity, UUID> {

}
