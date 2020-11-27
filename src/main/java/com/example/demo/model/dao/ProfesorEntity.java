package com.example.demo.model.dao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Profesores")
public class ProfesorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Código",length = 8)
    private int cod;

    @Column(name = "Nombres", length = 50)
    private String first_name;

    @Column(name = "Apellidos", length = 50)
    private String last_name;

    @Column(name = "Correo_Universidad", length = 50)
    private String email_univ;

    @Column(name = "Correo_Personal", length = 50)
    private String email_priv;

    @Column(name = "Foto_Url", length = 100)
    private String photo_url;

    //[Profesor]M-------1[Género]
    @ManyToOne
    private GeneroEntity gender;

    //[Profesor]M-------1[País]
    @ManyToOne
    private PaisEntity pais;

    //[Profesor]M-------1[Tipo]
    @ManyToOne
    private ProfesorTipoEntity type;

    @ManyToMany(mappedBy = "profesor")
    private List<SeccionEntity> secciones;

    public ProfesorEntity() {
    }

    public ProfesorEntity(Long id, int cod, String first_name, String last_name, String email_univ, String email_priv, String photo_url) {
        this.id = id;
        this.cod = cod;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email_univ = email_univ;
        this.email_priv = email_priv;
        this.photo_url = photo_url;
    }

    public ProfesorEntity(Long id, int cod, String first_name, String last_name, String email_univ, String email_priv, String photo_url, GeneroEntity gender, PaisEntity pais, ProfesorTipoEntity type) {
        this.id = id;
        this.cod = cod;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email_univ = email_univ;
        this.email_priv = email_priv;
        this.photo_url = photo_url;
        this.gender = gender;
        this.pais = pais;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail_univ() {
        return email_univ;
    }

    public void setEmail_univ(String email_univ) {
        this.email_univ = email_univ;
    }

    public String getEmail_priv() {
        return email_priv;
    }

    public void setEmail_priv(String email_priv) {
        this.email_priv = email_priv;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public GeneroEntity getGender() {
        return gender;
    }

    public void setGender(GeneroEntity gender) {
        this.gender = gender;
    }

    public PaisEntity getPais() {
        return pais;
    }

    public void setPais(PaisEntity pais) {
        this.pais = pais;
    }

    public ProfesorTipoEntity getType() {
        return type;
    }

    public void setType(ProfesorTipoEntity type) {
        this.type = type;
    }

    public List<SeccionEntity> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<SeccionEntity> secciones) {
        this.secciones = secciones;
    }
}
