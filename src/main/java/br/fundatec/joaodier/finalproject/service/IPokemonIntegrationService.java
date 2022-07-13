package br.fundatec.joaodier.finalproject.service;

import br.fundatec.joaodier.finalproject.service.dto.PokemonDTO;

public interface IPokemonIntegrationService {
    PokemonDTO getPokemonById(Integer id);
}
