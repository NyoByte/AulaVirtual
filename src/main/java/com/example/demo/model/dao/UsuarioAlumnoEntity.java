package com.example.demo.model.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Usuarios_Alumnos")
public class UsuarioAlumnoEntity extends UsuarioEntity implements Serializable {

    @ManyToOne
    private AlumnoEntity alumno;

    public UsuarioAlumnoEntity() {
    }

    public UsuarioAlumnoEntity(AlumnoEntity alumno) {
        this.alumno = alumno;
    }

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
