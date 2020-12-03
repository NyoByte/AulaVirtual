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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
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

    @RequestMapping(value = "/alumno/guardar_masivo", method = RequestMethod.POST)
    public String guardarCSV(@RequestParam MultipartFile file) throws IOException{
        //Leer el archivo
        InputStream inputStream = file.getInputStream();
        byte[] bArray = new byte[inputStream.available()];
        inputStream.read(bArray);

        //Transformar bytes a String
        String data = new String(bArray);
        inputStream.close();

        //Remover espacios en blanco
        data = data.replaceAll(" ","");

        //Dividir lineas
        String[] alumnos = data.split("\n");

        //Tratar linea x linea
        for(String alumno: alumnos){
            String[] alDatos = alumno.split(",");
            //Crear nuevo alumno
            //public AlumnoEntity(Long id, int cod, String first_name, String last_name, String email_univ, String email_priv, String tv_user, String tv_pw, String ad_cred)
            AlumnoEntity newAl = new AlumnoEntity(null, Integer.parseInt(alDatos[0]),alDatos[1],alDatos[2], alDatos[3], alDatos[4],alDatos[5],alDatos[6],alDatos[7]);
            alumnoRep.save(newAl);
        }
        return "redirect:/alumno";

    }
}
