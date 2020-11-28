package com.example.demo.model.dao;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Usuarios_Profesores")
public class UsuarioProfesorEntity extends UsuarioEntity{
    @ManyToOne
    private ProfesorEntity profesor;

    public UsuarioProfesorEntity(Long id, String user, String pw, ProfesorEntity profesor) {
        super(id, user, pw);
        this.profesor = profesor;
    }

    public ProfesorEntity getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorEntity profesor) {
        this.profesor = profesor;
    }
}
