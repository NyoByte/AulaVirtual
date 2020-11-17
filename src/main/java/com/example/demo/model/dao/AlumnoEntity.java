package com.example.demo.model.dao;

import javax.persistence.*;

@Entity
@Table(name = "Alumnos")
public class AlumnoEntity {
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

    @Column(name = "TeamViewer_Usuario", length = 15)
    private String TV_user;

    @Column(name = "TeamViewer_Contraseña", length = 15)
    private String TV_pw;

    @Column(name = "AnyDesk_Credencial", length = 10)
    private String AD_cred;

    //[Alumno]M-------1[Género]
    @ManyToOne
    private GeneroEntity gender;

    //[Alumno]M-------1[Carrera]
    @ManyToOne
    private CarreraEntity career;

    //[Alumno]M-------1[País]
    @ManyToOne
    private PaisEntity pais;

    public AlumnoEntity() {
    }

    public AlumnoEntity(Long id, int cod, String first_name, String last_name, String email_univ, String email_priv, String TV_user, String TV_pw, String AD_cred) {
        this.id = id;
        this.cod = cod;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email_univ = email_univ;
        this.email_priv = email_priv;
        this.TV_user = TV_user;
        this.TV_pw = TV_pw;
        this.AD_cred = AD_cred;
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

    public String getTV_user() {
        return TV_user;
    }

    public void setTV_user(String TV_user) {
        this.TV_user = TV_user;
    }

    public String getTV_pw() {
        return TV_pw;
    }

    public void setTV_pw(String TV_pw) {
        this.TV_pw = TV_pw;
    }

    public String getAD_cred() {
        return AD_cred;
    }

    public void setAD_cred(String AD_cred) {
        this.AD_cred = AD_cred;
    }

    public GeneroEntity getGender() {
        return gender;
    }

    public void setGender(GeneroEntity gender) {
        this.gender = gender;
    }

    public CarreraEntity getCareer() {
        return career;
    }

    public void setCareer(CarreraEntity career) {
        this.career = career;
    }

    public PaisEntity getPais() {
        return pais;
    }

    public void setPais(PaisEntity pais) {
        this.pais = pais;
    }
}

