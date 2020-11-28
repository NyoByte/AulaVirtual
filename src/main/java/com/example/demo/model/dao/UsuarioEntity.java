package com.example.demo.model.dao;

import javax.persistence.*;

@MappedSuperclass
@Table(name = "Usuarios")
public class UsuarioEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "Usuario", unique = true, length = 45)
    protected String user;

    @Column(name = "Contraseña", length = 45)
    protected String pw;

    public UsuarioEntity() {
    }

    public UsuarioEntity(Long id, String user, String pw) {
        this.id = id;
        this.user = user;
        this.pw = pw;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}