package br.fundatec.joaodier.finalproject.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "\"PokemonType\"")
public class PokemonType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Id_Pokemon_Type\"", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"Id_Pokemon\"", nullable = false)
    private Pokemon idPokemon;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"Id_Type\"", nullable = false)
    private Type idType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pokemon getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(Pokemon idPokemon) {
        this.idPokemon = idPokemon;
    }

    public Type getIdType() {
        return idType;
    }

    public void setIdType(Type idType) {
        this.idType = idType;
    }

}