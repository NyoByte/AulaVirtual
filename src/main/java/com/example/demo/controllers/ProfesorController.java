package com.example.demo.controllers;

import com.example.demo.forms.GuardarAlumnosForm;
import com.example.demo.forms.GuardarProfesorForm;
import com.example.demo.model.dao.*;
import com.example.demo.model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.charset.StandardCharsets;
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
    @RequestMapping(value = "/profesor/guardar", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String guardarProfesor(GuardarProfesorForm form) {
        //Si es un nuevo profesor

        int cod = Integer.parseInt(form.getCod());
        String first_name = form.getFirst_name();
        String last_name = form.getLast_name();
        String email_univ = form.getEmail_univ();
        String email_priv = form.getEmail_priv();
        String type = form.getType();
        String photo_url = form.getPhoto_url();


        Long idTipo = Long.parseLong(form.getType());
        Long idPais = Long.parseLong(form.getPais());
        Long idGenero = Long.parseLong(form.getGender());

        Optional<ProfesorEntity> opProfesor = profesorRep.findById(Long.parseLong(form.getId()));
        if(opProfesor.isPresent()) {
            ProfesorEntity profesor = opProfesor.get();
            // Editar un profesor existe
            profesor.setCod(cod);
            profesor.setFirst_name(first_name);
            profesor.setLast_name(last_name);
            profesor.setEmail_univ(email_univ);
            profesor.setEmail_priv(email_univ);
            profesor.setPhoto_url("newFoto.img");

            profesor.setType(tipoRep.findById(idTipo).get());
            profesorRep.save(profesor);
            profesor.setPais(paisRep.findById(idPais).get());
            profesorRep.save(profesor);
            profesor.setGender(generoRep.findById(idGenero).get());
            profesorRep.save(profesor);

        }else{
            ProfesorEntity newProfesor = new ProfesorEntity( null, cod, first_name, last_name, email_univ, email_priv, "fotito.png");

            Optional<ProfesorTipoEntity> opTipo = tipoRep.findById(idTipo);
            if (opTipo.isPresent()) {
                newProfesor.setType(opTipo.get());
                profesorRep.save(newProfesor);
            }

            Optional<PaisEntity> opPais = paisRep.findById(idPais);
            if (opPais.isPresent()) {
                newProfesor.setPais(opPais.get());
                profesorRep.save(newProfesor);
            }

            Optional<GeneroEntity> opGenero = generoRep.findById(idGenero);
            if (opGenero.isPresent()) {
                newProfesor.setGender(opGenero.get());
                profesorRep.save(newProfesor);
            }
            //Crear su usuario
            String user = newProfesor.getEmail_univ();
            String pw = String.valueOf(newProfesor.getCod());
            UsuarioProfesorEntity usuario = new UsuarioProfesorEntity(null,user,pw,newProfesor);
            usuarioRep.save(usuario);
        }
        return "redirect:/profesor";
    }
    @RequestMapping(value = "/profesor/update", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String actualizarDatosProfesor(GuardarProfesorForm profesorForm){
        String nuevoCorreoPriv = profesorForm.getEmail_priv();

        //Obtener representacion del alumno que esta logueado actualmente
        HttpSession sesion = ObtenerSesion();
        ProfesorEntity profesorLogueado = (ProfesorEntity) sesion.getAttribute("identificador");
        System.out.println("identificador obtenido correctamente");

        //Obtener el alumno de la BD
        Optional<ProfesorEntity> profesorOP = profesorRep.findById(profesorLogueado.getId());

        if(profesorOP.isPresent()) {
            ProfesorEntity profesorActual = profesorOP.get();
            System.out.println("Profesor obtenido de la BD");
            //Actualizar datos
            profesorActual.setEmail_priv(nuevoCorreoPriv);
            System.out.println("Datos actualizados correctamente");
            profesorRep.save(profesorActual);
            System.out.println("Profesor actualizado en la bd");
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/profesor/guardar_masivo", method = RequestMethod.POST)
    public String guardarCSV(@RequestParam MultipartFile file) throws IOException {

        //Leer el archivo
        InputStream inputStream = file.getInputStream();

        int fileSize = inputStream.available();

        byte[] bArray = new byte[fileSize];

        inputStream.read(bArray);

        String data = new String(bArray);

        inputStream.close();

        //Remover espacios en blanco
        data = data.replaceAll(" ","");

        //Dividir lineas
        String[] profesores = data.split("\n");
        for(String profe: profesores){
            //Crear nuevo profesor
            String[] profDatos = profe.split(",");
            //public ProfesorEntity(Long id, int cod, String first_name, String last_name, String email_univ, String email_priv)
            ProfesorEntity newProf = new ProfesorEntity(null,Integer.parseInt(profDatos[0]),profDatos[1],profDatos[2],profDatos[3],profDatos[4]);
            //Guardar nuevo registro en bd
            profesorRep.save(newProf);
        }
        return "redirect:/profesor";
    }
    // HTTP Session
    private HttpSession ObtenerSesion(){
        final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getSession();
    }
}
