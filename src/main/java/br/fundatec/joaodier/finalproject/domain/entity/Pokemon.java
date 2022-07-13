package br.fundatec.joaodier.finalproject.domain.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "pokemon", schema = "Pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 125)
    private String name;

    @OneToMany(mappedBy = "pokemon", orphanRemoval = true)
    private Set<PokemonType> pokemonTypes = new LinkedHashSet<>();

    public Pokemon(Long id, String name, Set<PokemonType> pokemonTypes) {
        this.id = id;
        this.name = name;
        this.pokemonTypes = pokemonTypes;
    }

    @Deprecated
    public Pokemon() {
    }

    public Set<PokemonType> getPokemonTypes() {
        return pokemonTypes;
    }

    public void setPokemonTypes(Set<PokemonType> pokemonTypes) {
        this.pokemonTypes = pokemonTypes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}