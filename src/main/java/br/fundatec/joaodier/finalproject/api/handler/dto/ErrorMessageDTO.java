package br.fundatec.joaodier.finalproject.api.handler.dto;

import lombok.Builder;

@Builder
public record ErrorMessageDTO(String message) {
}
