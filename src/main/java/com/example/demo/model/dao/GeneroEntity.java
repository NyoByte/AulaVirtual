package com.example.demo.model.dao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Géneros")
public class GeneroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre", unique = true, length = 15)
    private String name;

    @OneToMany(mappedBy = "gender")
    private List<AlumnoEntity> listAlumnos;

    @OneToMany(mappedBy = "gender")
    private List<ProfesorEntity> listProfesores;

    /* Constructor */
    public GeneroEntity() {
    }

    public GeneroEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /* Getter & Setter */
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
