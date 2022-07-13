package br.fundatec.joaodier.finalproject.service.Implementation;

import br.fundatec.joaodier.finalproject.api.handler.exception.NotFoundException;
import br.fundatec.joaodier.finalproject.domain.vo.PokemonResponseVO;
import br.fundatec.joaodier.finalproject.service.IPokemonIntegrationService;
import br.fundatec.joaodier.finalproject.service.dto.PokemonDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonIntegrationService implements IPokemonIntegrationService {

    @Value("${poke-api-uri}")
    private String uri;
    private final RestTemplate restTemplate;

    public PokemonIntegrationService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public PokemonDTO getPokemonByName(String name) {
        String generatedUrl = generateRequestedUrl(name);

        return PokemonDTO.create(getPokeApiResponse(generatedUrl));
    }

    public PokemonDTO getPokemonById(Integer id) {
        String generatedUrl = generateRequestedUrl(id);

        return PokemonDTO.create(getPokeApiResponse(generatedUrl));
    }

    private PokemonResponseVO getPokeApiResponse(String param) {
        PokemonResponseVO response = this.restTemplate.getForObject(param, PokemonResponseVO.class);
        if (response == null) throw new NotFoundException("Pokemon not found: " + param);

        return response;
    }

    private @NotNull String generateRequestedUrl(Object param) {
        return this.uri + "/" + param;
    }
}
