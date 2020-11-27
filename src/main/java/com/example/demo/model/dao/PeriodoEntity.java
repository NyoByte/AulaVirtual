package com.example.demo.model.dao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Periodos")
public class PeriodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre", length = 7)
    private String name;

    @Column(name = "Año")
    private int year;

    @OneToMany(mappedBy = "periodo")
    private List<SeccionEntity> listSecciones;

    public PeriodoEntity() {
    }

    public PeriodoEntity(Long id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<SeccionEntity> getListSecciones() {
        return listSecciones;
    }

    public void setListSecciones(List<SeccionEntity> listSecciones) {
        this.listSecciones = listSecciones;
    }
}
