package br.fundatec.joaodier.finalproject.api.handler.dto;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
public record ApiResponseDTO(LocalDateTime time, HttpStatus status, Set<ErrorMessageDTO> errors) {
}
