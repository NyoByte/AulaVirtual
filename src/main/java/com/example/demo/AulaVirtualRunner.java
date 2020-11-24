package com.example.demo;

import com.example.demo.model.dao.AlumnoEntity;
import com.example.demo.model.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AulaVirtualRunner implements CommandLineRunner {
    @Autowired
    private AlumnoRepository alumnoRep;


    @Override
    public void run(String... args) throws Exception{
    /*
        AlumnoEntity alumno1 = new AlumnoEntity(null,20173527,"Andy","Lazo",
                "20173527@aloe.ulima.edu.pe","andyLazo@hotmail.com",
                "andy","andyl","154165171","fotito.jpe");

        alumnoRep.save(alumno1);
    */
    }
}
