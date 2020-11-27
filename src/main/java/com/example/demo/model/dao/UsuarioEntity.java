package com.example.demo.model.dao;

import javax.persistence.*;

@Entity
@Table(name = "Usuarios")
public class UsuarioEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
