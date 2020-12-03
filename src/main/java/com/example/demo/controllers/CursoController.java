package com.example.demo.controllers;

import com.example.demo.forms.GuardarCursoForm;
import com.example.demo.forms.GuardarProfesorForm;
import com.example.demo.model.dao.*;
import com.example.demo.model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    @RequestMapping(value = "/curso/guardar", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)

    public String guardarCurso(GuardarCursoForm form) {
        //Si es un nuevo curso
        int cod = Integer.parseInt(form.getCod());
        String name = form.getName();
        Long idCarrera = Long.parseLong(form.getCareer());

        CursoEntity curso = cursoRep.findByCod(cod);
        if (curso != null) {
            // Editar un curso existe
            curso.setCod(cod);
            curso.setName(name);

            curso.setCareer(carreraRep.findById(idCarrera).get());
            cursoRep.save(curso);


        } else {
            CursoEntity newCurso = new CursoEntity(null, cod, name);

            Optional<CarreraEntity> opCarrera = carreraRep.findById(idCarrera);
            if (opCarrera.isPresent()) {
                newCurso.setCareer(opCarrera.get());
                cursoRep.save(newCurso);
            }


        }
        return "redirect:/curso";
    }


}
