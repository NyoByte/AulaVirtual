package com.example.demo.model.dao;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Usuarios_Administradores")
public class UsuarioAdministradorEntity extends UsuarioEntity implements Serializable {

    public UsuarioAdministradorEntity() {
    }

    public UsuarioAdministradorEntity(Long id, String user, String pw) {
        super(id, user, pw);
    }
}
