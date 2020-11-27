package com.example.demo.model.dao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cursos")
public class CursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Código")
    private int cod;

    @Column(name = "Nombre",length = 50)
    private String name;

    //[Curso]M-------1[Carrera]
    @ManyToOne
    private CarreraEntity career;

    @OneToMany(mappedBy = "course")
    private List<SeccionEntity> listSecciones;

    /* Constructor */
    public CursoEntity() {
    }

    public CursoEntity(Long id, int cod, String name) {
        this.id = id;
        this.cod = cod;
        this.name = name;
    }

    public CursoEntity(Long id, int cod, String name, CarreraEntity career) {
        this.id = id;
        this.cod = cod;
        this.name = name;
        this.career = career;
    }

    /* Getter & Setter*/
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarreraEntity getCareer() {
        return career;
    }

    public void setCareer(CarreraEntity career) {
        this.career = career;
    }
}
