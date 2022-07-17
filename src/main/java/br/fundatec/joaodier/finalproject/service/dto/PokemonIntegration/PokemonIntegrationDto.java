package br.fundatec.joaodier.finalproject.service.dto.PokemonIntegration;

import br.fundatec.joaodier.finalproject.domain.vo.PokemonResponseVO;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.Objects;

@Builder
@Data
public class PokemonIntegrationDto {

    private Integer id;
    private Integer weight;
    private Integer heigth;
    private String name;
    private String sprites;
    private Collection<PokemonIntegrationMovesDto> moves;
    private Collection<PokemonIntegrationTypesDto> types;

    public static PokemonIntegrationDto create(ResponseEntity<PokemonResponseVO> param) {
        return PokemonIntegrationDto.builder()
                .id(Objects.requireNonNull(param.getBody()).getId())
                .name(Objects.requireNonNull(param.getBody().getName()))
                .weight(param.getBody().getWeight())
                .heigth(param.getBody().getHeight())
                .build();
    }
}