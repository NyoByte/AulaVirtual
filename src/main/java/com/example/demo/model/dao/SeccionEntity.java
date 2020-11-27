package com.example.demo.model.dao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Secciones")
public class SeccionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Código")
    private String cod;

    @ManyToOne
    private CursoEntity course;

    @ManyToOne
    private PeriodoEntity period;

    public SeccionEntity() {
    }

    public SeccionEntity(Long id, String cod) {
        this.id = id;
        this.cod = cod;
    }

    public SeccionEntity(Long id, String cod, CursoEntity course, PeriodoEntity period) {
        this.id = id;
        this.cod = cod;
        this.course = course;
        this.period = period;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public CursoEntity getCourse() {
        return course;
    }

    public void setCourse(CursoEntity course) {
        this.course = course;
    }

    public PeriodoEntity getPeriod() {
        return period;
    }

    public void setPeriod(PeriodoEntity period) {
        this.period = period;
    }
}
