package com.example.demo.controllers;

import com.example.demo.forms.GuardarAlumnosForm;
import com.example.demo.forms.GuardarSeccionForm;
import com.example.demo.model.dao.AlumnoEntity;
import com.example.demo.model.dao.PeriodoEntity;
import com.example.demo.model.dao.ProfesorEntity;
import com.example.demo.model.dao.SeccionEntity;
import com.example.demo.model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
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

    @RequestMapping(value = "/seccion/guardar", method = RequestMethod.POST)
    public String agregarSeccion(GuardarSeccionForm form, Model model){
        int codigo = Integer.parseInt(form.getCod());
        Long idCurso = Long.parseLong(form.getCourse());
        // los profesores devuelven el codigo del profesor como value del formulario
        int codProfe1 = Integer.parseInt(form.getProfesorT1_name());
        int codProfe2 = Integer.parseInt(form.getProfesorT2_name());
        //Asignarle un periodo respecto al año y mes en el que se encuentra
        int year = LocalDateTime.now().getYear();
        int mes = LocalDateTime.now().getMonthValue();
        List<PeriodoEntity> periodos = periodoRep.findByYear(year);
        //Se decide en que periodo está
        Long idPeriodoActual;
        if (mes<=6){
            //Aqui es para año-I
            PeriodoEntity periodoActual = periodos.get(0);
            idPeriodoActual = periodoActual.getId();
        }else{
            //Aqui es para año-II
            PeriodoEntity periodoActual = periodos.get(1);
            idPeriodoActual = periodoActual.getId();
        }
        SeccionEntity newSeccion = new SeccionEntity(null,codigo);
        newSeccion.setCourse(cursoRep.findById(idCurso).get());             seccionRep.save(newSeccion);
        newSeccion.setPeriodo(periodoRep.findById(idPeriodoActual).get());  seccionRep.save(newSeccion);
        //Obtener profesores de la seccion
        //Se debe buscar por codigo
        ProfesorEntity opProfeT1 = profesorRep.findByCod(codProfe1);
        ProfesorEntity opProfeT2 = profesorRep.findByCod(codProfe2);
        //Asignar Profesores
        List<ProfesorEntity> listaProfes =  new ArrayList<>();
        if (opProfeT1 != null){
            System.out.println(opProfeT1.getFirst_name());
            listaProfes.add(opProfeT1);
        }
        if (opProfeT2 != null){
            System.out.println(opProfeT2.getFirst_name());
            listaProfes.add(opProfeT2);
        }
        System.out.println("===");
        System.out.println(listaProfes.get(0).getFirst_name());
        System.out.println(listaProfes.get(1).getFirst_name());
        newSeccion.setProfesor(listaProfes);
        seccionRep.save(newSeccion);
        //Obtener id del curso recién creado
        Long id = newSeccion.getId();
        String path = "redirect:/seccion?edit=true&seccion_id="+id;
        return path;
    }

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
