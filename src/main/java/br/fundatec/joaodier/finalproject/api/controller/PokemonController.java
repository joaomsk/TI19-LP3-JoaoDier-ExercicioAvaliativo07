package br.fundatec.joaodier.finalproject.api.controller;

import br.fundatec.joaodier.finalproject.service.IPokemonIntegrationService;
import br.fundatec.joaodier.finalproject.service.dto.PokemonIntegration.PokemonIntegrationDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    private final IPokemonIntegrationService pokemonIntegrationService;

    public PokemonController(IPokemonIntegrationService pokemonIntegrationService) {
        this.pokemonIntegrationService = pokemonIntegrationService;
    }

    @GetMapping("pokeapi/{id}")
    public PokemonIntegrationDto PokemonById(@PathVariable Integer id) {
        return pokemonIntegrationService.getPokemonById(id);
    }

    @GetMapping("pokeapi/name/{name}")
    public PokemonIntegrationDto PokemonByName(@PathVariable String name) {
        return pokemonIntegrationService.getPokemonByName(name);
    }
}
