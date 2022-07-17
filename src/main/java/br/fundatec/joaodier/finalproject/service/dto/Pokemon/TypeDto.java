package br.fundatec.joaodier.finalproject.service.dto.Pokemon;

import lombok.Data;

import java.io.Serializable;

@Data
public class TypeDto implements Serializable {
    private final Integer id;
    private final String typeName;
}
