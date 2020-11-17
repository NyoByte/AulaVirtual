package com.example.demo.controllers;


import com.example.demo.model.dao.AlumnoEntity;
import com.example.demo.model.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class AulaVirtualController {
    @Autowired
    private AlumnoRepository alumnoRep;

    //LOGIN:
    // http://localhost:8080/aula_virtual/login/profesor
    @RequestMapping(value = "/aula_virtual/login/profesor", method = RequestMethod.GET)
    public String mostrarLogin_Profesor(){
        return "Login_Profesor";
    }
    // http://localhost:8080/aula_virtual/login/estudiante
    @RequestMapping(value = "/aula_virtual/login/estudiante", method = RequestMethod.GET)
    public String mostrarLogin_Estudiante(){
        return "Login_Estudiante";
    }
    // http://localhost:8080/aula_virtual/login/administrador
    @RequestMapping(value = "/aula_virtual/login/administrador", method = RequestMethod.GET)
    public String mostrarLogin_Administrador(){
        return "Login_Administrador";
    }
    
    //ALUMNO:
    // http://localhost:8080/aula_virtual/alumno
    @RequestMapping(value = "/aula_virtual/alumno", method = RequestMethod.GET)
    public String mostrarAlumno(){
        return "Alumno";
    }

    //PROFESOR:
    // http://localhost:8080/aula_virtual/profesor/datos
    @RequestMapping(value="/aula_virtual/profesor/datos", method = RequestMethod.GET)
    public String mostrarProfesor(){
        return "Profesor";
    }
    // http://localhost:8080/aula_virtual/profesor/secciones
    @RequestMapping(value="/aula_virtual/profesor/secciones", method = RequestMethod.GET)
    public String mostrarProfesor_Sección(){
        return "Profesor_Sección";
    }

    //ADMINISTRADOR:
    //*CARGAS
    // http://localhost:8080/aula_virtual/administrador/alumnos
    @RequestMapping(value="/aula_virtual/administrador/alumnos", method = RequestMethod.GET)
    public String mostrarAdmin_CargaAlumnos(){
        return "Admin_CargaAlumnos";
    }
    // http://localhost:8080/aula_virtual/administrador/cursos
    @RequestMapping(value="/aula_virtual/administrador/cursos", method = RequestMethod.GET)
    public String mostrarAdmin_CargaCursos(){
        return "Admin_CargaCursos";
    }
    // http://localhost:8080/aula_virtual/administrador/profesores
    @RequestMapping(value="/aula_virtual/administrador/profesores", method = RequestMethod.GET)
    public String mostrarAdmin_CargaProfesores(){
        return "Admin_CargaProfesores";
    }
    // http://localhost:8080/aula_virtual/administrador/secciones
    @RequestMapping(value="/aula_virtual/administrador/secciones", method = RequestMethod.GET)
    public String mostrarAdmin_CargaSecciones(){
        return "Admin_CargaSecciones";
    }
    //*CRUDS:
    // http://localhost:8080/aula_virtual/administrador/alumnos/edit
    @RequestMapping(value="/aula_virtual/administrador/alumnos/edit", method = RequestMethod.GET)
    public String mostrarAdmin_CrudAlumno(){
        return "Admin_CrudAlumno";
    }
    // http://localhost:8080/aula_virtual/administrador/cursos/edit
    @RequestMapping(value="/aula_virtual/administrador/cursos/edit", method = RequestMethod.GET)
    public String mostrarAdmin_CrudCurso(){
        return "Admin_CrudCurso";
    }
    // http://localhost:8080/aula_virtual/administrador/profesores/edit
    @RequestMapping(value="/aula_virtual/administrador/profesores/edit", method = RequestMethod.GET)
    public String mostrarAdmin_CrudProfesor(){
        return "Admin_CrudProfesor";
    }
    // http://localhost:8080/aula_virtual/administrador/secciones/edit
    @RequestMapping(value="/aula_virtual/administrador/secciones/edit", method = RequestMethod.GET)
    public String mostrarAdmin_CrudSección(){
        return "Admin_CrudSección";
    }
    
    //TESTER
    // http://localhost:8080/test
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String mostrarTest(){
        //Copia tu código en el archivo test.jsp
        return "test";
    }


    /* FUNCIONES */
    @RequestMapping(value = "/aula_virtual/administrador/alumnos/edit/{cod}", method = RequestMethod.GET)
    public String editarAlumno(Model model, @PathVariable String cod) {
        Optional<AlumnoEntity> tempAlumno = alumnoRep.findById(Long.parseLong(cod));
        if (tempAlumno.isPresent()){
            model.addAttribute("alumno", tempAlumno.get());
        }
        return "Admin_CrudAlumno";
    }

}
