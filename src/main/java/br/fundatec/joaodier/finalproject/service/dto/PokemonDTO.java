package br.fundatec.joaodier.finalproject.service.dto;

import br.fundatec.joaodier.finalproject.domain.vo.PokemonResponseVO;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Builder
@Data
public class PokemonDTO {

    private Integer id;
    private Integer weight;
    private Integer heigth;
    private String name;
    private String sprites;
    private Collection<PokemonMovesDTO> moves;
    private Collection<PokemonTypesDTO> types;

    public static PokemonDTO create(PokemonResponseVO param) {
        return PokemonDTO.builder()
                .id(param.getId())
                .name(param.getName())
                .weight(param.getWeight())
                .heigth(param.getHeight())
                .build();
    }
}