package com.example.demo.controllers;

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
public class ProfesorController {
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

    @RequestMapping(value = "/profesor/eliminar/{id}", method = RequestMethod.POST)
    public String eliminarProfesor(@PathVariable String id){
        Optional<ProfesorEntity> profesorSeleccionado = profesorRep.findById(Long.parseLong(id));
        if(profesorSeleccionado.isPresent()){
            List<SeccionEntity> secciones = profesorSeleccionado.get().getSecciones();
            for(SeccionEntity seccion:secciones){
                List<ProfesorEntity> profesores = seccion.getProfesor();
                List<ProfesorEntity> newProfesor = new ArrayList<>();
                for(ProfesorEntity profesor:profesores){
                    if(profesor.getId()!=Long.parseLong(id)){
                        newProfesor.add(profesor);
                    }
                }
                seccion.setProfesor(newProfesor);
                seccionRep.save(seccion);
            }
            profesorRep.delete(profesorSeleccionado.get());
        }
        return  "redirect:/profesor";
    }
}
