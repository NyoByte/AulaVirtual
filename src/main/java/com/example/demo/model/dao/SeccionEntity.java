package com.example.demo.model.dao;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Secciones")
public class SeccionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Código", unique = true, length = 8)
    private int cod;

    @ManyToOne
    private CursoEntity course;

    @ManyToOne
    private PeriodoEntity periodo;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<AlumnoEntity> alumnos;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<ProfesorEntity> profesor;

    public SeccionEntity() {
    }

    public SeccionEntity(Long id, int cod) {
        this.id = id;
        this.cod = cod;
    }

    public SeccionEntity(Long id, int cod, CursoEntity course, PeriodoEntity periodo) {
        this.id = id;
        this.cod = cod;
        this.course = course;
        this.periodo = periodo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public CursoEntity getCourse() {
        return course;
    }

    public void setCourse(CursoEntity course) {
        this.course = course;
    }

    public PeriodoEntity getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoEntity periodo) {
        this.periodo = periodo;
    }

    public List<AlumnoEntity> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<AlumnoEntity> alumnos) {
        this.alumnos = alumnos;
    }

    public List<ProfesorEntity> getProfesor() {
        return profesor;
    }

    public void setProfesor(List<ProfesorEntity> profesor) {
        this.profesor = profesor;
    }
}
