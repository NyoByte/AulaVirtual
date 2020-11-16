package com.example.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AulaVirtualController {

    // http://localhost:8080/
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mostrarAlumno(){
        return "Alumno";
    }

    // http://localhost:8080/aulaVirtual/administrador/alumnos
    @RequestMapping(value="/aulaVirtual/administrador/alumnos", method = RequestMethod.GET)
    public String mostrarAdmin_CargaAlumnos(){
        return "Admin_CargaAlumnos.jsp";
    }

    
    // http://localhost:8080/test
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String mostrarTest(){
        //Copia tu código en el archivo test.jsp
        return "test";
    }
}
