package br.fundatec.joaodier.finalproject.service.dto.Pokemon;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
@Builder
public class PokemonDto implements Serializable {
    private final Integer id;
    private final String name;
    private final Integer height;
    private final Integer weight;
    private final Instant createdAt;
    private final Instant deletedAt;
}
