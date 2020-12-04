package com.example.demo.controllers;

import com.example.demo.model.dao.AlumnoEntity;
import com.example.demo.model.dao.ProfesorEntity;
import com.example.demo.model.dao.SeccionEntity;
import com.example.demo.model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class SeccionController {
    @Autowired
    private AlumnoRepository alumnoRep;
    @Autowired
    private PaisRepository paisRep;
    @Autowired
    private GeneroRepository generoRep;
    @Autowired
    private CarreraRepository carreraRep;
    @Autowired
    private CursoRepository cursoRep;
    @Autowired
    private PeriodoRepository periodoRep;
    @Autowired
    private ProfesorRepository profesorRep;
    @Autowired
    private ProfesorTipoRepository tipoRep;
    @Autowired
    private SeccionRepostitory seccionRep;
    @Autowired
    private UsuarioRepository usuarioRep;

    @RequestMapping(value = "/seccion/eliminar/{id}", method = RequestMethod.POST)
    public String eliminarSeccion(@PathVariable String id){
        Optional<SeccionEntity> seccionSeleccionado = seccionRep.findById(Long.parseLong(id));
        if(seccionSeleccionado.isPresent()){
            //Eliminar a los alumnos de esa seccion
            seccionSeleccionado.get().setAlumnos(null);
            seccionRep.save(seccionSeleccionado.get());
            //Eliminar a los profesores de esa seccion
            seccionSeleccionado.get().setProfesor(null);
            seccionRep.save(seccionSeleccionado.get());
            //Eliminar la seccion
            seccionRep.delete(seccionSeleccionado.get());
        }
        return  "redirect:/seccion";
    }

}
