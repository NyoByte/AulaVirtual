package com.example.demo.controllers;

import com.example.demo.model.dao.ProfesorEntity;
import com.example.demo.model.dao.SeccionEntity;
import com.example.demo.model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
}
