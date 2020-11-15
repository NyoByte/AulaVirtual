package com.example.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AulaVirtualController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mostrarAlumno(){
        return "alumno";
    }
}
