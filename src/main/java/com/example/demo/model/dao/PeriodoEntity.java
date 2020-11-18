package com.example.demo.model.dao;

import javax.persistence.*;

@Entity
@Table(name = "Periodos")
public class PeriodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre", length = 7)
    private String name;

    @Column(name = "Año")
    private int year;
}
