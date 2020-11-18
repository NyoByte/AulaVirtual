package com.example.demo.model.dao;

import javax.persistence.*;

@Entity
public class ProfesorTipoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre")
    private String name;
}
