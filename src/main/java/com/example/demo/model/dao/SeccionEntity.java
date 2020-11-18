package com.example.demo.model.dao;

import javax.persistence.*;

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
            ;
}
