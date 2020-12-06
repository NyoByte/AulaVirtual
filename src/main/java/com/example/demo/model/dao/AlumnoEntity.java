package com.example.demo.model.dao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Alumnos")
public class AlumnoEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Código", unique = true, length = 8)
    private int cod;

    @Column(name = "Nombres", length = 50)
    private String first_name;

    @Column(name = "Apellidos", length = 50)
    private String last_name;

    @Column(name = "Correo_Universidad", unique = true, length = 50)
    private String email_univ;

    @Column(name = "Correo_Personal", unique = true, length = 50)
    private String email_priv;

    @Column(name = "TeamViewer_Usuario", unique = true, length = 9)
    private String tv_user;

    @Column(name = "TeamViewer_Contraseña", length = 9)
    private String tv_pw;

    @Column(name = "AnyDesk_Credencial", unique = true, length = 6)
    private String ad_cred;

    @Column(name = "Foto_Url", length = 100)
    private String photo_url;

    //[Alumno]M-------1[Género]
    @ManyToOne
    private GeneroEntity gender;

    //[Alumno]M-------1[Carrera]
    @ManyToOne
    private CarreraEntity career;

    //[Alumno]M-------1[País]
    @ManyToOne
    private PaisEntity pais;

    @ManyToMany(mappedBy = "alumnos")
    private List<SeccionEntity> secciones;

    @OneToOne(mappedBy = "alumno")
    private UsuarioAlumnoEntity usuarioAlumno;


    public AlumnoEntity() {
    }

    public AlumnoEntity(Long id, int cod, String first_name, String last_name, String email_univ, String email_priv, String tv_user, String tv_pw, String ad_cred, String photo_url) {
        this.id = id;
        this.cod = cod;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email_univ = email_univ;
        this.email_priv = email_priv;
        this.tv_user = tv_user;
        this.tv_pw = tv_pw;
        this.ad_cred = ad_cred;
        this.photo_url = photo_url;
    }

    public AlumnoEntity(Long id, int cod, String first_name, String last_name, String email_univ, String email_priv, String tv_user, String tv_pw, String ad_cred, String photo_url, GeneroEntity gender, CarreraEntity career, PaisEntity pais) {
        this.id = id;
        this.cod = cod;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email_univ = email_univ;
        this.email_priv = email_priv;
        this.tv_user = tv_user;
        this.tv_pw = tv_pw;
        this.ad_cred = ad_cred;
        this.photo_url = photo_url;
        this.gender = gender;
        this.career = career;
        this.pais = pais;
    }
    // Para el CSV, se le quito que pida url
    public AlumnoEntity(Long id, int cod, String first_name, String last_name, String email_univ, String email_priv, String tv_user, String tv_pw, String ad_cred) {
        this.id = id;
        this.cod = cod;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email_univ = email_univ;
        this.email_priv = email_priv;
        this.tv_user = tv_user;
        this.tv_pw = tv_pw;
        this.ad_cred = ad_cred;
    }

    public AlumnoEntity(Long id, int cod, String first_name, String last_name, String email_univ, String email_priv, String tv_user, String tv_pw, String ad_cred, GeneroEntity gender, CarreraEntity career, PaisEntity pais) {
        this.id = id;
        this.cod = cod;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email_univ = email_univ;
        this.email_priv = email_priv;
        this.tv_user = tv_user;
        this.tv_pw = tv_pw;
        this.ad_cred = ad_cred;
        this.gender = gender;
        this.career = career;
        this.pais = pais;
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

    public String getTv_user() {
        return tv_user;
    }

    public void setTv_user(String tv_user) {
        this.tv_user = tv_user;
    }

    public String getTv_pw() {
        return tv_pw;
    }

    public void setTv_pw(String tv_pw) {
        this.tv_pw = tv_pw;
    }

    public String getAd_cred() {
        return ad_cred;
    }

    public void setAd_cred(String ad_cred) {
        this.ad_cred = ad_cred;
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

    public List<SeccionEntity> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<SeccionEntity> secciones) {
        this.secciones = secciones;
    }

    public UsuarioAlumnoEntity getUsuarioAlumno() {
        return usuarioAlumno;
    }

    public void setUsuarioAlumno(UsuarioAlumnoEntity usuarioAlumno) {
        this.usuarioAlumno = usuarioAlumno;
    }
}

