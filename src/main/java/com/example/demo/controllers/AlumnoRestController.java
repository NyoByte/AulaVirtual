package com.example.demo.controllers;

import com.example.demo.model.dao.AlumnoEntity;
import com.example.demo.model.dto.AlumnoDTO;
import com.example.demo.model.repositories.AlumnoRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AlumnoRestController {
    @Autowired
    private AlumnoRepository alumnoRepository;

    @RequestMapping(value = "resources/alumno", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getAll() {
        List<AlumnoEntity> listaAlumnos = alumnoRepository.findAll();

        List<AlumnoDTO> listaDTO = new ArrayList<>();
        for(AlumnoEntity al: listaAlumnos){
            AlumnoDTO newAL = new AlumnoDTO(al.getId(), al.getCod(), al.getFirst_name(), al.getLast_name(), al.getEmail_univ(), al.getEmail_priv(), al.getTv_user(),
                    al.getTv_pw(), al.getAd_cred(), al.getPhoto_url());
            listaDTO.add(newAL);
        }

        Gson gson = new Gson();
        return gson.toJson(listaDTO);
    }
}
