package br.fundatec.joaodier.finalproject.domain.vo;

import lombok.Data;

import java.util.ArrayList;

@Data
public class PokemonResponseVO {
    public int id;
    public String name;
    public int weight;
    public int height;
    public String location_area_encounters;
    public ArrayList<PokemonMovesResponseVO> moves;
    public ArrayList<PokemonTypeSlotsResponseVO> types;
}
