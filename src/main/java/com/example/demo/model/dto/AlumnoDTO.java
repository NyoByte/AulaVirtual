package com.example.demo.model.dto;

import com.example.demo.model.dao.CarreraEntity;
import com.example.demo.model.dao.GeneroEntity;
import com.example.demo.model.dao.PaisEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

public class AlumnoDTO {
    private Long id;

    private int cod;

    private String first_name;

    private String last_name;

    private String email_univ;

    private String email_priv;

    private String tv_user;

    private String tv_pw;

    private String ad_cred;

    private String photo_url;

    public AlumnoDTO(Long id, int cod, String first_name, String last_name, String email_univ, String email_priv, String tv_user, String tv_pw, String ad_cred, String photo_url) {
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
}
