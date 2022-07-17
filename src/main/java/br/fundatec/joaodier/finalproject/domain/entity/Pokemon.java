package br.fundatec.joaodier.finalproject.domain.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "\"Pokemon\"")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Id_Pokemon\"", nullable = false)
    private Integer id;

    @Column(name = "\"Name\"", nullable = false, length = 150)
    private String name;

    @Column(name = "\"Height\"", nullable = false)
    private Integer height;

    @Column(name = "\"Weight\"", nullable = false)
    private Integer weight;

    @Column(name = "\"Created_At\"", nullable = false)
    private Instant createdAt;

    @Column(name = "\"Deleted_At\"")
    private Instant deletedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }

}