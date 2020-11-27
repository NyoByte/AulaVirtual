package com.example.demo.model.dao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Tipos de Profesor")
public class ProfesorTipoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre")
    private String name;

    @OneToMany(mappedBy = "type")
    private List<ProfesorEntity> listProfesores;

    public ProfesorTipoEntity() {
    }

    public ProfesorTipoEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProfesorEntity> getListProfesores() {
        return listProfesores;
    }

    public void setListProfesores(List<ProfesorEntity> listProfesores) {
        this.listProfesores = listProfesores;
    }
}
