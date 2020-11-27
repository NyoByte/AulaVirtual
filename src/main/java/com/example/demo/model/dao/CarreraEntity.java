package com.example.demo.model.dao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Carreras")
public class CarreraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre", length = 25)
    private String name;

    @OneToMany(mappedBy = "career")
    private List<AlumnoEntity> listAlumnos;

    //[Curso]M-------1[Carrera]
    @OneToMany(mappedBy = "career")
    private List<CursoEntity> listCursos;

    /* Constructor */
    public CarreraEntity() {
    }

    public CarreraEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /* Constructor */
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

    public List<CursoEntity> getListCursos() {
        return listCursos;
    }

    public void setListCursos(List<CursoEntity> listCursos) {
        this.listCursos = listCursos;
    }
}

