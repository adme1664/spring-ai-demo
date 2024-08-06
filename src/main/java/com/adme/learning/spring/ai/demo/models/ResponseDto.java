package com.adme.learning.spring.ai.demo.models;

import java.util.UUID;

public record ResponseDto(UUID id, String message, String sender, String receiver) {

}
