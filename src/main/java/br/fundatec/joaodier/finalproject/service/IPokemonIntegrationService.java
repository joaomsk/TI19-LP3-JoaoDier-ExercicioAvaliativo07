package br.fundatec.joaodier.finalproject.service;

import br.fundatec.joaodier.finalproject.service.dto.PokemonIntegration.PokemonIntegrationDto;

public interface IPokemonIntegrationService {
    PokemonIntegrationDto getPokemonById(Integer id);
    PokemonIntegrationDto getPokemonByName(String name);
}
