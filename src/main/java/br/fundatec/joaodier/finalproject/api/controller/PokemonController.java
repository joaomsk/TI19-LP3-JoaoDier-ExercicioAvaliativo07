package br.fundatec.joaodier.finalproject.api.controller;

import br.fundatec.joaodier.finalproject.service.IPokemonIntegrationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    private final IPokemonIntegrationService pokemonIntegrationService;

    public PokemonController(IPokemonIntegrationService pokemonIntegrationService) {
        this.pokemonIntegrationService = pokemonIntegrationService;
    }
}
