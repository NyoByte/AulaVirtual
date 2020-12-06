package com.example.demo.forms;

public class GuardarSeccionForm {
    private String cod;
    private String course;
    private String profesorT1_name;
    private String profesorT2_name;
    private String id;

    public GuardarSeccionForm() {
    }

    public String getCod() {
        return cod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getProfesorT1_name() {
        return profesorT1_name;
    }

    public void setProfesorT1_name(String profesorT1_name) {
        this.profesorT1_name = profesorT1_name;
    }

    public String getProfesorT2_name() {
        return profesorT2_name;
    }

    public void setProfesorT2_name(String profesorT2_name) {
        this.profesorT2_name = profesorT2_name;
    }
}
