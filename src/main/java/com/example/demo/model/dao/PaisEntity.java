package com.example.demo.model.dao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Países")
public class PaisEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre",length = 30)
    private String name;

    @OneToMany(mappedBy = "pais")
    private List<AlumnoEntity> listAlumnos;

    @OneToMany(mappedBy = "pais")
    private List<ProfesorEntity> listProfesores;

    /* Constructor */
    public PaisEntity() {
    }

    public PaisEntity(Long id, String name) {
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

    public List<AlumnoEntity> getListAlumnos() {
        return listAlumnos;
    }

    public void setListAlumnos(List<AlumnoEntity> listAlumnos) {
        this.listAlumnos = listAlumnos;
    }

    public List<ProfesorEntity> getListProfesores() {
        return listProfesores;
    }

    public void setListProfesores(List<ProfesorEntity> listProfesores) {
        this.listProfesores = listProfesores;
    }
}
