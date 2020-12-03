package com.example.demo.forms;

public class GuardarProfesorForm {
    private String cod;
    private String first_name;
    private String last_name;
    private String email_univ;
    private String email_priv;
    private String photo_url;
    private String gender;
    private String pais;
    private String type;

    public GuardarProfesorForm() {
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
