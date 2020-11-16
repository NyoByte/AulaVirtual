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


    @Column(name = "Correo_Personal", length = 50)
    private String email_priv;  //HMM

    @Column(name = "Género", length = 10)
    private String gender;  // ??

    @Column(name = "TeamViewer_Usuario", length = 15)
    private String TV_user;

    @Column(name = "TeamViewer_Contraseña", length = 15)
    private String TV_pw;

    @Column(name = "AnyDesk_Credencial", length = 10)
    private String AD_cred;

    //[País]M-------1[Alumno]
    @ManyToOne
    private PaisEntity pais;

    //[Carrera]M-------1[Alumno]
    @ManyToOne
    private CarreraEntity career;

    public AlumnoEntity() {
    }

}

