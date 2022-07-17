package br.fundatec.joaodier.finalproject.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "\"Types\"")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Id_Type\"", nullable = false)
    private Integer id;

    @Column(name = "\"TypeName\"", nullable = false, length = 100)
    private String typeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}