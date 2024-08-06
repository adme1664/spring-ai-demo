package com.adme.learning.spring.ai.demo.mapper;

import com.adme.learning.spring.ai.demo.entities.ResponseEntity;
import com.adme.learning.spring.ai.demo.models.ResponseDto;

public class ResponseMapper {

  public static ResponseDto mapToDto(ResponseEntity responseEntity) {
    return new ResponseDto(responseEntity.id(), responseEntity.message(), responseEntity.sender(),
        responseEntity.receiver());
  }

  public static ResponseEntity mapToResponseEntity(ResponseDto dto) {
    return new ResponseEntity(dto.id(), dto.message(), dto.sender(), dto.receiver());
  }

}
