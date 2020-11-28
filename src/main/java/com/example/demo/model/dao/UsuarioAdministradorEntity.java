package com.example.demo.model.dao;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Usuarios_Administradores")
public class UsuarioAdministradorEntity extends UsuarioEntity{

    public UsuarioAdministradorEntity(Long id, String user, String pw) {
        super(id, user, pw);
    }
}
