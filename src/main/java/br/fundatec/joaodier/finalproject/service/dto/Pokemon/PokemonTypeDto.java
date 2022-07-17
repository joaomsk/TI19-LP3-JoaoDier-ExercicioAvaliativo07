package br.fundatec.joaodier.finalproject.service.dto.Pokemon;

import lombok.Data;

import java.io.Serializable;

@Data
public class PokemonTypeDto implements Serializable {
    private final Integer id;
    private final PokemonDto idPokemon;
    private final TypeDto idType;
}
