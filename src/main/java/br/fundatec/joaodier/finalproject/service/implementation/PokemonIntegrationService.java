package br.fundatec.joaodier.finalproject.service.implementation;

import br.fundatec.joaodier.finalproject.api.handler.ExceptionHandlerAdvice;
import br.fundatec.joaodier.finalproject.domain.vo.PokemonResponseVO;
import br.fundatec.joaodier.finalproject.service.IPokemonIntegrationService;
import br.fundatec.joaodier.finalproject.service.dto.PokemonIntegration.PokemonIntegrationDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonIntegrationService implements IPokemonIntegrationService {

    @Value("${poke-api-uri}")
    private String uri;
    private final RestTemplate restTemplate;

    public PokemonIntegrationService(RestTemplateBuilder builder) {
        this.restTemplate = builder
                .errorHandler(new ExceptionHandlerAdvice())
                .build();
    }

    public PokemonIntegrationDto getPokemonByName(String name) {
        String generatedUrl = generateRequestedUrl(name);

        return PokemonIntegrationDto.create(getPokeApiResponse(generatedUrl));
    }

    public PokemonIntegrationDto getPokemonById(Integer id) {
        String generatedUrl = generateRequestedUrl(id);

        return PokemonIntegrationDto.create(getPokeApiResponse(generatedUrl));
    }

    private ResponseEntity<PokemonResponseVO> getPokeApiResponse(String param) {
        return this.restTemplate.getForEntity(param, PokemonResponseVO.class);
    }

    private @NotNull String generateRequestedUrl(Object param) {
        return this.uri + "/" + param;
    }
}
