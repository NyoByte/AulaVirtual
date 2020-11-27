package com.example.demo.model.dao;

import javax.persistence.*;

@Entity
@Table(name = "Usuarios_Alumnos")
public class UsuarioAlumnoEntity extends UsuarioEntity{

    @ManyToOne
    private AlumnoEntity alumno;

    public UsuarioAlumnoEntity(Long id, String user, String pw, AlumnoEntity alumno) {
        super(id, user, pw);
        this.alumno = alumno;
    }

    public AlumnoEntity getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoEntity alumno) {
        this.alumno = alumno;
    }
}
