package br.fundatec.joaodier.finalproject.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "pokemon_type", schema = "Pokemon")
public class PokemonType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "pokemon_type_desc")
    private PokemonTypeEnum pokemonTypeDescription;

    @ManyToOne
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public PokemonTypeEnum getPokemonTypeDescription() {
        return pokemonTypeDescription;
    }

    public void setPokemonTypeDescription(PokemonTypeEnum pokemonTypeDesc) {
        this.pokemonTypeDescription = pokemonTypeDesc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}