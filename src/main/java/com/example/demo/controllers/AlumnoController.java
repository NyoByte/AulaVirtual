package com.example.demo.controllers;

import com.example.demo.forms.GuardarAlumnosForm;
import com.example.demo.model.dao.*;
import com.example.demo.model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AlumnoController {
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

    @RequestMapping(value = "/alumno/guardar", method = RequestMethod.POST,  consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String guardarAlumno(GuardarAlumnosForm form) {

        AlumnoEntity a1 = new AlumnoEntity();
        a1.setCod(Integer.parseInt(form.getCod()));
        a1.setFirst_name(form.getFirst_name());
        a1.setLast_name(form.getLast_name());
        a1.setEmail_univ(form.getEmail_univ());
        a1.setEmail_priv(form.getEmail_priv());
        a1.setTv_user(form.getTv_user());
        a1.setTv_pw(form.getTv_pw());
        a1.setAd_cred(form.getAd_cred());
        a1.setPhoto_url(form.getPhoto_url());

        Long idCarrera = Long.parseLong(form.getCareer());
        Optional<CarreraEntity> opCarrera = carreraRep.findById(idCarrera);
        if (opCarrera.isPresent()) {
            a1.setCareer(opCarrera.get());
            alumnoRep.save(a1);
        }
        Long idPais = Long.parseLong(form.getPais());
        Optional<PaisEntity> opPais = paisRep.findById(idPais);
        if (opPais.isPresent()) {
            a1.setPais(opPais.get());
            alumnoRep.save(a1);
        }
        Long idGenero = Long.parseLong(form.getGender());
        Optional<GeneroEntity> opGenero = generoRep.findById(idGenero);
        if (opGenero.isPresent()) {
            a1.setGender(opGenero.get());
            alumnoRep.save(a1);
        }

        return "redirect:/alumno";

    }

    @RequestMapping(value = "/alumno/eliminar/{id}", method = RequestMethod.POST)
    public String eliminarAlumno(@PathVariable String id){
        Optional<AlumnoEntity> alumnoSeleccionado = alumnoRep.findById(Long.parseLong(id));
        if(alumnoSeleccionado.isPresent()){
            List<SeccionEntity> secciones = alumnoSeleccionado.get().getSecciones();
            for(SeccionEntity seccion:secciones){
                List<AlumnoEntity> alumnos = seccion.getAlumnos();
                List<AlumnoEntity> newAlumnos = new ArrayList<>();
                for(AlumnoEntity alumno:alumnos){
                    if(alumno.getId()!=Long.parseLong(id)){
                        newAlumnos.add(alumno);
                    }
                }
                seccion.setAlumnos(newAlumnos);
                seccionRep.save(seccion);
            }
            alumnoRep.delete(alumnoSeleccionado.get());
        }
        return  "redirect:/alumno";
    }
}
