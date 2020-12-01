package com.example.demo.controllers;

import com.example.demo.model.dao.CursoEntity;
import com.example.demo.model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class CursoController {
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

    @RequestMapping(value = "/curso/eliminar/{id}", method = RequestMethod.POST)
    public String eliminarCurso(@PathVariable String id){
        Optional<CursoEntity> cursoSeleccionado = cursoRep.findById(Long.parseLong(id));
        if(cursoSeleccionado.isPresent()){
            cursoRep.delete(cursoSeleccionado.get());
        }
        return  "redirect:/curso";
    }
}
