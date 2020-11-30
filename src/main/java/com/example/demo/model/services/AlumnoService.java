package com.example.demo.model.services;

import com.example.demo.model.dao.AlumnoEntity;
import com.example.demo.model.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRep;

    /*public List<AlumnoEntity> findByKeywordName(String keyword){
        return alumnoRep.findByKeywordName(keyword);
    }*/

    /*public List<AlumnoEntity> findByKeywordCode(String keyword){
        return alumnoRep.findByKeywordCode(keyword);
    }*/
}
